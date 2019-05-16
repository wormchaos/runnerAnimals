package com.wormchaos.service;

import com.wormchaos.entity.User;

/**
 * Created by wormchaos on 2019-5-16.
 */
public interface UserService {

    /**
     * 查询用户
     * @param userId
     * @return
     */
    User getUser(Long userId);
}
