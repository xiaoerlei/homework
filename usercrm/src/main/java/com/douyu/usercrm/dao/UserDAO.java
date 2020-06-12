package com.douyu.usercrm.dao;

import com.douyu.usercrm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {

    // 保存用户的方法
    void save(User user);

    // 登录的方法
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    // 查询所有用户信息，用户找回密码
    List<User> findAll();

    // 查询单个
    User findUserById(String id);

    // 更新用户
    void update(User user);
}
