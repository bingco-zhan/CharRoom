package com.bingco.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC连接池工具类
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-15 21:40
 * Package com.bingco.util
 * -----------------------------------------------------
 */
public class JdbcUtil {

    private static DataSource source;

    public static Connection getConnection() throws SQLException {
        if (source == null) source = new ComboPooledDataSource("mysql");
        return source.getConnection();
    }
}
