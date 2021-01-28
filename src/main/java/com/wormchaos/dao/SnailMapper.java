package com.wormchaos.dao;

import com.wormchaos.dao.utils.BaseDao;
import com.wormchaos.entity.Snail;

/**
 * Created by Raytine on 2021/1/28.
 */
public interface SnailMapper extends BaseDao<Snail> {

    /**
     * 根据userId查询数据
     * @param userId
     * @return
     */
    Snail findByUserId(Long userId);

    /**
     * 更新
     * @param snail
     */
    void updateInfo(Snail snail);
}
