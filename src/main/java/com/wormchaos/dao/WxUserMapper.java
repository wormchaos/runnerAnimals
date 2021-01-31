package com.wormchaos.dao;

import com.wormchaos.dao.utils.BaseDao;
import com.wormchaos.entity.User;
import com.wormchaos.entity.WxUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Raytine on 2021/1/28.
 */
public interface WxUserMapper extends BaseDao<WxUser> {

    /**
     * 获取用户openId
     * @param token
     * @return
     */
    String findOpenIdByToken(String token);

    /**
     * 用户是否注册
     * @param openId
     * @return
     */
    Integer isExists(String openId);

    // replace by insert
//    void saveUser(String openId, String code);

    void updateUser(@Param(value = "openId") String openId,
                    @Param(value = "code") String code,
                    @Param(value = "token") String token);

}
