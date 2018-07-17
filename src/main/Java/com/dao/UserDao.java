package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findUserByName(String username);
    public void addUser(@Param("username")String username,@Param("password")String password);
}
