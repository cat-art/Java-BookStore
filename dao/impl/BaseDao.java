package com.bookStore.dao.impl;

import com.alibaba.druid.util.JdbcUtils;
import com.bookStore.utils.JavaUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();
    /**
     *  实现增删改的通用操作
     *  sql占位符中的个数与可变长参数的长度一致！！
     * @param sql
     * @param args
     * @return
     */
    public int insert_Delete_Update(String sql, Object ...args) {
        Connection con = JavaUtils.getDBConnect();
        try {
            return queryRunner.update(con,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询一条javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql, Object ...args) {
        Connection con = JavaUtils.getDBConnect();
        try {
            return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    /**
     * 查询多个javaBean的sql语句
     * @param <T> 返回的类型的泛型
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql,Object ...args) {
        Connection con = JavaUtils.getDBConnect();
        try {
            //我这太惨了 因为之前没注意传入的参数new BeanListHandler 为list类型 导致后面做不出来
            List<T> query = queryRunner.query(con, sql, new BeanListHandler<T>(type),args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    /**
     *
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingValue(String sql, Object... args) {
        Connection con = JavaUtils.getDBConnect();
        try {
            return queryRunner.query(con,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
             JdbcUtils.close(con);
        }
        return null;
    }
}









