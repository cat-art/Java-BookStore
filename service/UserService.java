package com.bookStore.service;
import com.bookStore.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 如果返回空说明登录失败
     */
    public boolean existUsername(String username);

}
