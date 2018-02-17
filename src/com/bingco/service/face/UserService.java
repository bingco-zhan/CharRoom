package com.bingco.service.face;

import com.bingco.pojo.User;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

/**
 * 用户业务逻辑层接口
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-15 20:40
 * Package com.bingco.service.face
 * -----------------------------------------------------
 */
public interface UserService {

    public Map<String, Object> login(String username, String password, HttpSession session) throws SQLException;

    public User findById(int id) throws SQLException;

}
