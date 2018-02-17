package com.bingco.socket;

import com.bingco.pojo.User;
import com.bingco.service.face.UserService;
import com.bingco.service.impl.UserServiceImpl;
import com.bingco.util.WebUtil;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * @author bingco
 * @version v1.0
 * By 2018-02-16 7:53
 * Package com.bingco.servlet
 * -----------------------------------------------------
 */
@ServerEndpoint(value = "/char", configurator = WebSocketConfigurator.class)
public class CharRoomSocketHandler {

    private static UserService userService = new UserServiceImpl();

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws SQLException {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("HttpSession");
        int token = (int) httpSession.getServletContext().getAttribute(session.getRequestParameterMap().get("cr").get(0));
        User user = userService.findById(token);
        if (user != null) { // 防止没登陆的用户
            user.setToken(session.getId());
            user.setSession(session.getRequestParameterMap().get("cr").get(0));
            SocketPool.setAttribute(session.getId(), createConncetion(user, session));
            sendMessage("{\"order\":\"planform\", \"speak\":\"用户 [- " + user.getNickname() + " -] 上线了.\"}", null);
            sendMessage("{\"order\":\"token\", \"speak\":\"" + session.getId() + "\"}", session);
        }
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        Map<String, String> parseXml = WebUtil.parseXml(message);
        executeOrder(parseXml, session);
    }

    @OnClose
    public void onCLose(Session session, CloseReason reason) {
        SocketConnection connection = SocketPool.getAttribute(session.getId());
        if (connection != null) { // 也许被踢下路线了
            User user = connection.getUser();
            sendMessage("{\"order\":\"planform\", \"speak\":\"用户 [- " + user.getNickname() + " -] 已下线.\"}", null);
            SocketPool.removeAtrribute(session.getId());
        }
    }

    @OnError
    public void onError(Session session, Throwable err) {

    }

    /**
     * 根据用户信息分析指令
     *
     * @param map
     */
    public void executeOrder(Map<String, String> map, Session session) {
        String order = map.get("order");
        switch(order){
            case "online":
                queryOnline(session);
                break;

            case "public":
                speakByPublic(map, session);
                break;
            case "private":
                speakByPrivate(map, session);
                break;

            case "sign out":
                signOut(map, session);
                break;

                default:;
        }
    }

    /**
     * 私发信息
     *
     * @param map 信息
     * @param session 发送方会话管道
     */
    private void speakByPrivate(Map<String, String> map, Session session) {
        // TODO 给个人发送信息,待开发/////
    }

    /**
     * 下线
     *
     * @param map 信息
     * @param session 发送方会话管道
     */
    private void signOut(Map<String, String> map, Session session) {
        SocketConnection connection = SocketPool.getAttribute(map.get("to"));
        System.out.println(connection + "fsfsfsfsf-------->>");
        if (connection != null) {
            Map<String, Object> properties = connection.getSession().getUserProperties();
            HttpSession httpSession = (HttpSession)properties.get("HttpSession");
            httpSession.getServletContext().removeAttribute(connection.getUser().getSession());
            SocketPool.removeAtrribute(map.get("to"));
            sendMessage("{\"order\":\"planform\", \"speak\":\"用户 [- " +
                    connection.getUser().getNickname() +" -] 被踢下线.\"}", null);
        }
    }

    /**
     * 群发信息
     *
     * @param map 信息
     * @param session 发送方会话管道
     */
    private void speakByPublic(Map<String, String> map, Session session) {
        SocketConnection conncetion = SocketPool.getAttribute(session.getId());
        conncetion.getUser().setToken(session.getId());
        map.put("from", new Gson().toJson(conncetion.getUser()));
        sendMessage(new Gson().toJson(map), null);
    }

    /**
     * 查询在线用户信息
     *
     * @param session 接受方的通信管道
     */
    private void queryOnline(Session session) {
        Map<String, SocketConnection> pool = SocketPool.getSocketPool();
        List<User> set = new ArrayList<>();
        for (Map.Entry<String, SocketConnection> entry :
                pool.entrySet()) {
            set.add(entry.getValue().getUser());
        }
        HashMap<String, Object> result = new HashMap<>();
        result.put("order", "online");
        result.put("list", set);
        String json = new Gson().toJson(result);
        sendMessage(json, session);
    }

    /**
     * 发送信息
     *
     * @param msg 信息
     * @param session 会话.如果会话为null就群发,否则私聊,session为接收方的会话管道.
     */
    private void sendMessage(String msg, Session session) {
        try {
            if(session != null) {
                session.getBasicRemote().sendText(msg);
            }

            else {
                Map<String, SocketConnection> socketPool = SocketPool.getSocketPool();
                for (Map.Entry<String, SocketConnection> entry :
                        socketPool.entrySet()) {
                    SocketConnection connection = entry.getValue();
                    Session send = connection.getSession();
                    if(send.isOpen()) {
                        send.getBasicRemote().sendText(msg);
                    }
                }
            }
        }

        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 创建连接
     *
     * @param user 用户表
     * @param session 会话
     */
    private SocketConnection createConncetion(User user, Session session) {
        return new SocketConnection(user, session);
    }

}
