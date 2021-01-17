package com.bookStore.dao.impl;
import com.bookStore.pojo.User;


//与数据库连接的Dao层 定义连接数据库的实例
public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
       /* select ID,USERNAME,PASSWORD1,EMAIL from T_USER where ID = 2*/
        String sql = "select ID,USERNAME,PASSWORD,EMAIL from T_USER where USERNAME=?";
        return (User) queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndpassword(String username, String password) {
        String sql = "select ID,USERNAME,PASSWORD,EMAIL from T_USER where USERNAME=? and PASSWORD = ?";
        return (User) queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
     /*   insert into t_user('username','password','email') values(?,?,?)*/
        String sql = "insert into T_USER(USERNAME,PASSWORD,EMAIL) values(?,?,?)";
        return insert_Delete_Update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

}













