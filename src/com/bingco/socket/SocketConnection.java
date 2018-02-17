package com.bingco.socket;

import com.bingco.pojo.User;

import javax.websocket.Session;

/**
 * 长连接属性封装类,用来存储用户信息和连接管道
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-16 14:07
 * Package com.bingco.socket
 * -----------------------------------------------------
 */
public class SocketConnection {

    private User user;
    private Session session;

    public SocketConnection(User user, Session session) {
        this.user = user;
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
