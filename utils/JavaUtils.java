package com.bookStore.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 *用来连接数据库的工具
 *获取数据库连接池
 * 存放数据库用的jar包
 * 就是数据库的驱动
 * 打开和关闭数据库
 */
public class JavaUtils {   //实现数据库连接和关闭的封装 体会Java编程的思想

    public static Connection getDBConnect() {
        //获取连接的三个基本信息
        String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
        String dbUser = "test";
        String dbPwd = "test";
        // 获取数据库连接方法, 返回Connection对象
        Connection con = null;
        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(dbURL, dbUser, dbPwd);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
  /*  关闭连接 放回数据库连接池*/
    public static void closeSources(PreparedStatement ps, Connection con) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
