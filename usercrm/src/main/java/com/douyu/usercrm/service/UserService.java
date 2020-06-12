package com.douyu.usercrm.service;

import com.douyu.usercrm.entity.User;

import java.util.List;

public interface UserService {
    // 保存用户
    void save(User user);

    // 登录功能
    User login(String username,String password);

    // 查询所有用户信息
    List<User> findAll();

    // 查询单个用户信息
    User findUserById(String id);

    // 更新用户
    void update(User user);
}
