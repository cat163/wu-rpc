package com.whq.wurpc.service;


import io.vertx.core.Vertx;

/**
 * @author: whq
 * @description:
 * @time: 2024/5/21 15:47
 */
public class VertxHttpServer implements HttpServer{

    public void doStart(int port) {
        // 创建Vert.x实例
        Vertx vertx = Vertx.vertx();

        // 创建Http服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        // 监听端口并处理请求
        server.requestHandler(new HttpServerHandler());
//        server.requestHandler(request -> {
//            // 处理http请求
//            System.out.println("Received request: " + request.method() + " " + request.uri());
//
//            request.response()
//                    .putHeader("content-type", "text/plain")
//                    .end("hello world");
//        });

        // 启动Http服务器并监听指定端口
        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is now listening on port " + port);
            } else {
                System.err.println("Failed to start server: " + result.cause());
            }
        });

    }
}
