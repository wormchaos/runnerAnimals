package com.wormchaos.dao;

import com.wormchaos.dao.utils.BaseDao;
import com.wormchaos.entity.WxUser;

/**
 * Created by Raytine on 2021/1/28.
 */
public interface WxUserMapper extends BaseDao<WxUser> {

    /**
     * 查看用户是否登录状态
     * @param code
     * @return
     */
    String findOpenIdByCode(String code);

    /**
     * 用户是否注册
     * @param openId
     * @return
     */
    Integer isExists(String openId);

    // replace by insert
//    void saveUser(String openId, String code);

    void updateUser(String openId, String code);
}
