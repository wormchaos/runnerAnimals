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
    void userLogin(String code, String openId);

    /**
     * 获取用户openId
     * @param code
     * @return
     */
    String getOpenId(String code);

}
