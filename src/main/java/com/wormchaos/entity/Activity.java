package com.wormchaos.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Data
@Table(name = "t_activity")
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
     * yyyy-MM-dd HH:mm:ss
     */
    private String activityBeginTime;

    /**
     * 活动结束时间
     * yyyy-MM-dd HH:mm:ss
     */
    private String activityEndTime;

    /**
     * 活动实际结束时间
     * yyyy-MM-dd HH:mm:ss
     */
    private String activityAbortTime;
}
