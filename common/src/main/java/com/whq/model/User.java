package com.whq.model;

import java.io.Serializable;

/**
 * @author: whq
 * @description: 用户实体类
 * @time: 2024/5/21 13:51
 */
public class User implements Serializable {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
