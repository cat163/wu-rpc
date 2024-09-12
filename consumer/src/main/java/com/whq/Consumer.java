package com.whq;

import com.whq.model.User;
import com.whq.service.UserService;

/**
 * @author: whq
 * @description: 服务消费者
 * @time: 2024/5/21 14:11
 */
public class Consumer {
    public static void main(String[] args) {
//        UserService userService = null;
//        User user = new User();
//        // 调用
//        User newUser = userService.getUser(user);
//        if (newUser == null) {
//            System.out.println("user == null");
//        } else {
//            System.out.println(newUser.getName());
//        }
        // 静态代理 坏处：每个服务接口都写一个实现类
//        UserServiceProxy userServiceProxy = new UserServiceProxy();
//        User user = new User();
//        user.setName("whq");
//        userServiceProxy.getUser(user);
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxyObject(UserService.class);
        User user = new User();
        user.setName("whq");
        userService.getUser(user);
    }
}