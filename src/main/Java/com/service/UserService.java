package com.service;

import com.pojo.User;

/**
 * Created by Times on 2018/7/9.
 */
public interface UserService {

    public  User findUserByName(String username);

    public void addUser(String username,String password);
}
