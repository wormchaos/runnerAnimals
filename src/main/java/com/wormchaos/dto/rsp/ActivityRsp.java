package com.wormchaos.dto.rsp;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Data
public class ActivityRsp implements Serializable {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String desc;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;
}
