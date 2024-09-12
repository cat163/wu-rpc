package com.whq.wurpc.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: whq
 * @description: 本地注册中心
 * @time: 2024/9/12 10:34
 */
public class LocalRegistry {

    /**
     * 注册信息存储
     */
    private static final Map<String, Class<?>> map = new ConcurrentHashMap<>();

    /**
     * 注册服务
     * @param serverName 服务名称
     * @param implClass 服务实现类
     */
    public static void registry(String serverName, Class<?> implClass) {
        map.put(serverName, implClass);
    }

    /**
     * 获取服务
     * @param serverName 服务名称
     * @return 服务实现类
     */
    public static Class<?> get(String serverName) {
        return map.get(serverName);
    }

    /**
     * 移除服务
     * @param serverName 服务名称
     */
    public static void remove(String serverName) {
        map.remove(serverName);
    }
}
