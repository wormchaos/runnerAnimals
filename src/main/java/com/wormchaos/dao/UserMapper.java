package com.wormchaos.dao;

import com.wormchaos.dao.utils.BaseDao;
import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wormchaos on 2019-5-16.
 */
public interface UserMapper extends BaseDao<User> {

    User getUserByUserId(Long userId);

    User getUserByOpenId(String openId);

    Long getMaxUserId();

    void updateAllowMessage(@Param("userId") Long userId, @Param("allowMessage") Integer allowMessage);

    List<User> getUsersByGroup(Integer groupId);
}
