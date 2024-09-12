package com.whq;

import com.whq.service.UserService;
import com.whq.service.impl.UserServiceImpl;
import com.whq.wurpc.registry.LocalRegistry;
import com.whq.wurpc.service.HttpServer;
import com.whq.wurpc.service.VertxHttpServer;

/**
 * @author: whq
 * @description: 服务提供者
 * @time: 2024/5/21 14:07
 */
public class Provider {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.registry(UserService.class.getName(), UserServiceImpl.class);

        // 启动服务
        HttpServer server  = new VertxHttpServer();
        server.doStart(8080);
    }
}
