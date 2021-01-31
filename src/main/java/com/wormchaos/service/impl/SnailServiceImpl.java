package com.wormchaos.service.impl;

import com.wormchaos.controller.exception.MyException;
import com.wormchaos.dao.SnailMapper;
import com.wormchaos.dao.UserMapper;
import com.wormchaos.dao.WxUserMapper;
import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.dto.rsp.snail.SnailRankRsp;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;
import com.wormchaos.dto.rsp.snail.UnbindSnailRsp;
import com.wormchaos.entity.Snail;
import com.wormchaos.entity.User;
import com.wormchaos.service.SnailService;
import com.wormchaos.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raytine on 2021/1/23.
 */
@Service
public class SnailServiceImpl implements SnailService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private WxUserMapper wxUserMapper;

    @Resource
    private SnailMapper snailMapper;

    @Resource
    private UserService userService;

    @Override
    public SnailUserRsp getUserInfo(Long userId) {
        SnailUserRsp rsp = new SnailUserRsp();
        // 找到用户
        User user = userMapper.getUserByUserId(userId);
        if (null == user) {
            rsp.setStatus(0);
            return rsp;
        }
        // 查询蜗牛是否绑定
        Snail snail = snailMapper.findByUserId(userId);
        if (null == snail) {
            rsp.setStatus(0);
            return rsp;
        }
        rsp.setStatus(1);
        rsp.setForce(snail.getArmForce());
        // 查询排名
        Integer rank = snailMapper.getRankByForce(userId);
        if (null != rsp.getGroupRank()) {
            if (rank > 25) {
                rsp.setGroupName("勘探组");
            } else {
                rsp.setGroupName("敢死组");
            }
        } else {
            rsp.setGroupName("-");
            rsp.setGroupRank("-");
        }
        rsp.setNickname(snail.getNickname());
        return rsp;
    }

    @Override
    public List<SnailRankRsp> getRankListByGroupId(Long userId, Integer groupId) {
        List<Snail> rankList = snailMapper.rankByGroupId(groupId);
        List<SnailRankRsp> rsp = new ArrayList<>();
        if (!CollectionUtils.isEmpty(rankList)) {
            Integer rank = 0;
            for (Snail s : rankList) {
                SnailRankRsp r = new SnailRankRsp();
                rank++;
                r.setNickname(s.getNickname());
                if (null != s.getArmForce()) {
                    r.setForce(String.valueOf(s.getArmForce()));
                } else {
                    r.setForce("-");
                }
//                r.setGroupRank(rank);
                if (null != s.getArmForce()) {
                    if (rank > 25) {
                        r.setGroupName("勘探");
                    } else {
                        r.setGroupName("敢死");
                    }
                }
                if (null == s.getUserId()) {
                    r.setBind(false);
                } else {
                    r.setBind(true);
                    r.setBold(userId == s.getUserId());
                }
                rsp.add(r);
            }
        }
        return rsp;
    }

    @Override
    public void bindSnail(Long userId, Long bindId) {
        // 检查是否已绑定
        if(null != snailMapper.findByUserId(userId)) {
            throw new MyException("您已绑定账号");
        }
        // 绑定
        snailMapper.bindSnail(userId, bindId);
    }

    @Override
    public List<UnbindSnailRsp> getUnbindUserList(Integer groupId) {
        List<Snail> snails = snailMapper.rankByGroupId(groupId);
        List<UnbindSnailRsp> rsp = new ArrayList<>();
        for (Snail s : snails) {
            if (null == s.getUserId()) {
                UnbindSnailRsp r = new UnbindSnailRsp();
                r.setBindId(s.getId());
                r.setNickname(s.getNickname());
                rsp.add(r);
            }
        }
        return rsp;
    }

    @Override
    public void updateForce(SaveSnailUser user, Long userId) {
        Snail snail = new Snail();
        snail.setUserId(userId);
        snail.setNickname(user.getNickname());
        snail.setArmForce(user.getForce());
        snailMapper.updateInfo(snail);
    }

}
