package com.wormchaos.dao;

import com.wormchaos.dao.utils.BaseDao;
import com.wormchaos.entity.Snail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 获取排序列表
     * @param groupId
     * @return
     */
    List<Snail> rankByGroupId(Integer groupId);

    /**
     * 绑定用户
     * @param userId
     * @param bindId
     */
    void bindSnail(@Param(value = "userId") Long userId, @Param(value = "bindId")Long bindId);

    /**
     * 根据领导力获取排名
     * @param userId
     * @return
     */
    Integer getRankByForce(Long userId);
}
