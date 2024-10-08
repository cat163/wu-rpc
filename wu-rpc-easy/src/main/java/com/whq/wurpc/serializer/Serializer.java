package com.whq.wurpc.serializer;

import java.io.IOException;

/**
 * 序列化接口
 */
public interface Serializer {

    /**
     * 序列化
     * @param object
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize(T object) throws IOException;


    /**
     * 反序列化
     * @param bytes
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize(byte[] bytes , Class<?> type) throws IOException;
}
