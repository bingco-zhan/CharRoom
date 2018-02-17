package com.bingco.dao.impl;

import com.bingco.dao.face.UserDao;
import com.bingco.pojo.User;
import com.bingco.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 用户数据访问层实现
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-15 20:43
 * Package com.bingco.dao.impl
 * -----------------------------------------------------
 */
public class UserDaoImpl implements UserDao {

    private QueryRunner runner = new QueryRunner();

    @Override
    public User findByusername(String username) throws SQLException {
        String SQL = "SELECT * FROM user WHERE username = ?";
        Connection connection = JdbcUtil.getConnection();
        User user = runner.query(connection, SQL, new BeanHandler<>(User.class), username);
        connection.close();
        return user;
    }

    @Override
    public User findById(int id) throws SQLException {
        String SQL = "SELECT * FROM user WHERE id = ?";
        Connection connection = JdbcUtil.getConnection();
        User user = runner.query(connection, SQL, new BeanHandler<>(User.class), id);
        connection.close();
        return user;
    }
}
