package com.wormchaos.service;

import com.wormchaos.dto.req.AddActivityReq;
import com.wormchaos.dto.rsp.ActivityRsp;

import java.util.List;

/**
 * Created by wormchaos on 2019-5-23.
 */
public interface ActivityService {

    /**
     * 根据用户权限查询活动列表
     * @param userId
     * @return
     */
    List<ActivityRsp> getActivityList(Long userId);

    /**
     * 添加活动
     * @param req
     */
    void addActivity(Long userId, AddActivityReq req);
}
