package com.bookStore.service.impl;

import com.bookStore.dao.impl.UserDao;
import com.bookStore.dao.impl.UserDaoImpl;
import com.bookStore.pojo.User;
import com.bookStore.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    //注册的时候 往数据库插入数据 包括用户名 密码 和 email
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    // 登录的时候返回 用户名和密码 做查询操作
    public User login(User user) {
     /*   if (userDao.queryUserByUsernameAndpassword(user.getUsername(),user.getPassword())==null) {
            return false;
        }else {
            return true;
        }*/
        return userDao.queryUserByUsernameAndpassword(user.getUsername(),user.getPassword());
    }

    @Override
    //注册的时候 需要判断 用户名是否跟数据库中的username重复
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null) {
            return false;
        }
        else {
            return true;
        }

    }
}
