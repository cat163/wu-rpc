package com.whq;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.whq.model.User;
import com.whq.service.UserService;
import com.whq.wurpc.model.RpcRequest;
import com.whq.wurpc.model.RpcResponse;
import com.whq.wurpc.serializer.JdkSerializer;
import com.whq.wurpc.serializer.Serializer;

import java.io.IOException;

/**
 * @author: whq
 * @description: 静态代理
 * @time: 2024/9/12 14:17
 */
public class UserServiceProxy implements UserService {

    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();

        // 发送请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serverName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class<?>[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()){
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
