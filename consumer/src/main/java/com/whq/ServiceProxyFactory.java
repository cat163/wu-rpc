package com.whq;

import java.lang.reflect.Proxy;

/**
 * @author: whq
 * @description: 服务代理工厂(用于创建代理对象)
 * @time: 2024/9/12 15:53
 */
public class ServiceProxyFactory {

    public static <T> T getProxyObject (Class<?> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }

}
