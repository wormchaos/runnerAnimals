package com.wormchaos.service;

import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;

/**
 * Created by Raytine on 2021/1/23.
 */
public interface SnailService {

    SnailUserRsp getUserInfo(String openId);

    Integer getRankOrderByForce(String openId);

    void saveSnailUser(SaveSnailUser user, String openId);
}
