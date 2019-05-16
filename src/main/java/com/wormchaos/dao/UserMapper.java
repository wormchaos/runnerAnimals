package com.wormchaos.dao;

import com.wormchaos.entity.User;

/**
 * Created by wormchaos on 2019-5-16.
 */
public interface UserMapper {

    User getUserByUserId(Long userId);
}
