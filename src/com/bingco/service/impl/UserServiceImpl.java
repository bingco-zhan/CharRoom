package com.bingco.service.impl;

import com.bingco.dao.face.UserDao;
import com.bingco.dao.impl.UserDaoImpl;
import com.bingco.pojo.User;
import com.bingco.service.face.UserService;
import com.bingco.util.WebUtil;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

/**
 * 用户业务逻辑层实现
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-15 20:40
 * Package com.bingco.service.impl
 * -----------------------------------------------------
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public Map<String, Object> login(String username, String password, HttpSession session) throws SQLException {
        System.out.println("dfadfsfsfsdfdsf-------------->>22, " + username + ", " + password);
        if (username == null || username.isEmpty()) {
            return WebUtil.sendMsg(1, "用户名称为空!", null);
        }

        if (password == null || password.isEmpty()) {
            return WebUtil.sendMsg(2, "用户密码为空!", null);
        }

        User user = userDao.findByusername(username);
        if (user == null) {
            return WebUtil.sendMsg(1, "用户名称不存在!", null);
        }

        else if (!user.getPassword().equals(password)) {
            return WebUtil.sendMsg(2, "用户密码错误!", null);
        }

        else {
            session.setAttribute("token", user.getId());
            return WebUtil.sendMsg(200, "登陆成功!", null);
        }
    }

    @Override
    public User findById(int id) throws SQLException {
        return userDao.findById(id);
    }
}