package com.wormchaos.service.impl;

import com.wormchaos.dao.UserMapper;
import com.wormchaos.entity.User;
import com.wormchaos.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Long userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getAll();
    }
}
