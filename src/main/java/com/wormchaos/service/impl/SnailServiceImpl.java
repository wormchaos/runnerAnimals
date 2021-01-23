package com.wormchaos.service.impl;

import com.wormchaos.dao.UserMapper;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;
import com.wormchaos.entity.User;
import com.wormchaos.service.SnailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Raytine on 2021/1/23.
 */
@Service
public class SnailServiceImpl implements SnailService {

    @Resource
    private UserMapper userMapper;
    @Override
    public SnailUserRsp getUserInfo(String openId) {
        User user = userMapper.getUserByOpenId(openId);
        if (null == user) {
            return null;
        }
        SnailUserRsp rsp = new SnailUserRsp();
        rsp.setStatus(1);
        rsp.setForce(user.getForce());
        // 查询排名
        rsp.setGroupRank(getRankOrderByForce(openId));
        if (null != rsp.getGroupRank()) {
            if (rsp.getGroupRank() > 25) {
                rsp.setGroupName("勘探组");
            } else {
                rsp.setGroupName("战斗组");
            }
        }
        return rsp;
    }

    @Override
    public Integer getRankOrderByForce(String openId) {
        return userMapper.getRankOrderByForce(openId);
    }
}
