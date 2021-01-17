package com.bookStore.dao.impl;

import com.bookStore.pojo.User;
/*
    此接口用于规范User表的常用操作
 */
public interface UserDao {
    /**
     *
     * @param username  通过用户名查询用户
     * @return
     */
    public User queryUserByUsername(String username);
    /**
     *
     * @param username   通过用户名和密码查询用户
     * @param password
     * @return
     */
    public User queryUserByUsernameAndpassword(String username,String password);

    /**
     *
     * @param user   保存用户
     * @return
     */
    public int saveUser(User user);


}
