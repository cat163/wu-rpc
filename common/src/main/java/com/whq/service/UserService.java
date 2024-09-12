package com.whq.service;

import com.whq.model.User;

/**
 * @author: whq
 * @description: 用户接口
 * @time: 2024/5/21 13:52
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);

}
