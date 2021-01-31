package com.wormchaos.service.impl;

import com.wormchaos.dao.UserMapper;
import com.wormchaos.dao.WxUserMapper;
import com.wormchaos.entity.User;
import com.wormchaos.entity.WxUser;
import com.wormchaos.service.UserService;
import org.apache.tomcat.util.buf.B2CConverter;
import org.apache.tomcat.util.security.ConcurrentMessageDigest;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.Timestamp;
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
    public String userLogin(String code, String openId) {
        boolean hasRegisted = wxUserMapper.isExists(openId) > 0;
        // 如果用户不存在，则注册
        if (!hasRegisted) {
            User user = new User();
            user.setUserId(userMapper.getMaxUserId() + 1);
            user.setOpenId(openId);
            userMapper.insert(user);
        }
        String token = createToken(openId);
        // 更新code
        if(wxUserMapper.isExists(openId) > 0) {
            wxUserMapper.updateUser(openId, code, token);
        } else {
            WxUser wxUser = new WxUser();
            wxUser.setCode(code);
            wxUser.setOpenId(openId);
            wxUser.setToken(token);
            wxUser.setCreateTime(new Date());
            wxUser.setUpdateTime(new Date());
            wxUserMapper.insert(wxUser);
        }
        return token;
    }

    private String createToken(String openId) {
        String orig = "SESSION" + openId + System.currentTimeMillis();
        try {
            byte[] buffer = ConcurrentMessageDigest.digestMD5(orig.getBytes(B2CConverter.getCharset("UTF-8")));
            return MD5Encoder.encode(buffer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getOpenIdByToken(String token) {
        String openId = wxUserMapper.findOpenIdByToken(token);
        return openId;
    }

    @Override
    public Long getUserIdByOpenId(String openId) {
        User user = userMapper.getUserByOpenId(openId);
        if (user == null) {
            return null;
        }
        return user.getUserId();
    }
}
