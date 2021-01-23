package com.wormchaos.dao;

import com.wormchaos.dao.utils.BaseDao;
import com.wormchaos.entity.User;

/**
 * Created by wormchaos on 2019-5-16.
 */
public interface UserMapper extends BaseDao<User> {

    User getUserByUserId(Long userId);

    User getUserByOpenId(String openId);

    Integer getRankOrderByForce(String openId);
}
