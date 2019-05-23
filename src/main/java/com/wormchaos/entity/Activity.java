package com.wormchaos.entity;

import lombok.Data;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Data
public class Activity {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 活动发起人userId
     */
    private Long adminUserId;

    /**
     * 活动激活状态
     *  0 待激活 1 激活 2结束
     */
    private Integer active;

    /**
     * 活动开始时间
     */
    private String activityBeginTime;

    /**
     * 活动结束时间
     */
    private String activityEndTime;

    /**
     * 活动实际结束时间
     */
    private String activityAbortTime;
}
