package com.wormchaos.service;

import com.wormchaos.entity.User;

import java.util.List;

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

    /**
     * 查询用户列表
     * @return
     */
    List<User> getUserList();

    /**
     * 获取新户
     * @param openId
     */
    String userLogin(String code, String openId);

    /**
     * 获取用户openId
     * @param token
     * @return
     */
    String getOpenIdByToken(String token);

    /**
     * 获取用户信息
     * @param openId
     * @return
     */
    Long getUserIdByOpenId(String openId);
}
