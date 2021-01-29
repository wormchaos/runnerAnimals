package com.wormchaos.service;

import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.dto.rsp.snail.SnailRankRsp;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;

import java.util.List;

/**
 * Created by Raytine on 2021/1/23.
 */
public interface SnailService {

    SnailUserRsp getUserInfo(String code);

    Integer getRankOrderByForce(String openId);

    void saveSnailUser(SaveSnailUser user, String code);

    List<SnailRankRsp> getRankListByGroupId(String code, Integer groupId);
}
