package com.whq.service.impl;

import com.whq.model.User;
import com.whq.service.UserService;

/**
 * @author: whq
 * @description: 用户服务实现类
 * @time: 2024/5/21 14:03
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
