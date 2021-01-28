package com.wormchaos.service.impl;

import com.wormchaos.dao.UserMapper;
import com.wormchaos.dao.WxUserMapper;
import com.wormchaos.entity.User;
import com.wormchaos.entity.WxUser;
import com.wormchaos.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private WxUserMapper wxUserMapper;

    @Override
    public User getUser(Long userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getAll();
    }

    @Override
    public void userLogin(String code, String openId) {
        User user = userMapper.getUserByOpenId(openId);
        // 如果用户不存在，则注册
        if (null == user) {
            user = new User();
            user.setOpenId(openId);
            user.setUserId(userMapper.getMaxUserId() + 1);
            userMapper.insert(user);
        }

        // 更新code
        if(wxUserMapper.isExists(openId) > 0) {
            wxUserMapper.updateUser(openId, code);
        } else {
            WxUser wxUser = new WxUser();
            wxUser.setCode(code);
            wxUser.setOpenId(openId);
            wxUser.setCreateTime(new Date());
            wxUser.setUpdateTime(new Date());
            wxUserMapper.insert(wxUser);
        }
    }

    @Override
    public String getOpenId(String code) {
        String openId = wxUserMapper.findOpenIdByCode(code);
        return openId;
    }
}
