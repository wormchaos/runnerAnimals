package com.wormchaos.service;

import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.dto.rsp.snail.SnailRankRsp;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;
import com.wormchaos.dto.rsp.snail.UnbindSnailRsp;

import java.util.List;

/**
 * Created by Raytine on 2021/1/23.
 */
public interface SnailService {

    SnailUserRsp getUserInfo(Long userId);

//    Integer getRankOrderByForce(String openId);
//
//    void saveSnailUser(SaveSnailUser user, String code);

    List<SnailRankRsp> getRankListByGroupId(Long userId, Integer groupId);

    void bindSnail(Long userId, Long bindId);

    List<UnbindSnailRsp> getUnbindUserList(Integer groupId);

    void updateForce(SaveSnailUser user, Long userId);
}
