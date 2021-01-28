package com.wormchaos.service.impl;

import com.wormchaos.controller.exception.MyException;
import com.wormchaos.dao.SnailMapper;
import com.wormchaos.dao.UserMapper;
import com.wormchaos.dao.WxUserMapper;
import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;
import com.wormchaos.entity.Snail;
import com.wormchaos.entity.User;
import com.wormchaos.service.SnailService;
import com.wormchaos.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public SnailUserRsp getUserInfo(String code) {
        SnailUserRsp rsp = new SnailUserRsp();
        String openId = wxUserMapper.findOpenIdByCode(code);
        if (null == openId) {
            throw new MyException("用户信息获取异常");
        }
        // 找到用户
        User user = userMapper.getUserByOpenId(openId);
        if (null == user || null == user.getUserId()) {
            rsp.setStatus(0);
            return rsp;
        }
        // 查询蜗牛是否绑定
        Snail snail = snailMapper.findByUserId(user.getUserId());
        if (null == snail) {
            rsp.setStatus(0);
            return rsp;
        }
        rsp.setStatus(1);
        rsp.setForce(snail.getArmForce());
        // 查询排名
        rsp.setGroupRank(getRankOrderByForce(openId));
        rsp.setNickname(snail.getNickname());
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

    @Override
    public void saveSnailUser(SaveSnailUser reqInfo, String code) {
        String openId = wxUserMapper.findOpenIdByCode(code);
        if (null == openId) {
            throw new MyException("用户信息获取异常");
        }
        // 找到用户
        User user = userMapper.getUserByOpenId(openId);
        if (null == user || null == user.getUserId()) {
            userService.userLogin(code, openId);
            user = userMapper.getUserByOpenId(openId);
        }
        Snail snail = snailMapper.findByUserId(user.getUserId());
        if(null == snail) {
            snail = new Snail();
            snail.setUserId(user.getUserId());
            snail.setArmForce(reqInfo.getForce());
            snail.setNickname(reqInfo.getNickname());
            snailMapper.insert(snail);
        } else {
            snail.setArmForce(reqInfo.getForce());
            snail.setNickname(reqInfo.getNickname());
            snailMapper.updateInfo(snail);
        }
    }

}
