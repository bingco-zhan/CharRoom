package com.bingco.dao.face;

import com.bingco.pojo.User;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 用户数据访问层接口
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-15 20:42
 * Package com.bingco.dao.face
 * -----------------------------------------------------
 */
public interface UserDao {

    public User findByusername(String username) throws SQLException;

    public User findById(int id) throws SQLException;
}
