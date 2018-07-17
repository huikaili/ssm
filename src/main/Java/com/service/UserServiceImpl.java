package com.service;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Times on 2018/7/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao UserDao;
    @Override
    public User findUserByName(String username) {
        User user = UserDao.findUserByName(username);
        return user;
    }

    @Override
    public void addUser(String username, String password) {

        UserDao.addUser(username, password);
    }
}
