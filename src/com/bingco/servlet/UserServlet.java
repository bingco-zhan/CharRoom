package com.bingco.servlet;

import com.bingco.service.face.UserService;
import com.bingco.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

/**
 * 用户相关请求处理业务层
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-14 23:12
 * Package com.bingco.servlet
 * -----------------------------------------------------
 */
public class UserServlet extends BaseServlet {

    private static UserService userService = new UserServiceImpl();

    /**
     * 用户登陆接口
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        System.out.println("1");
        Map<String, Object> result = userService.login(username, password, session);
        System.out.println(result);
        if ((int) result.get("code") == 200) {
            String JSESSIONID = getCookie(request, "JSESSIONID");
            session.getServletContext().setAttribute(JSESSIONID, session.getAttribute("token"));
            Cookie cookie = new Cookie("cr", JSESSIONID);
            response.addCookie(cookie);
            return "r:index.jsp";
        }
        else {
            request.setAttribute("msg", result);
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            return "d:./login.jsp";
        }
    }

    private String getCookie(HttpServletRequest request, String key) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(key)) return cookie.getValue();
        }
        return null;
    }
}