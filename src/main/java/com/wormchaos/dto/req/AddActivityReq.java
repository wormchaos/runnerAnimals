package com.wormchaos.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wormchaos on 2019-5-24.
 */
@Data
public class AddActivityReq implements Serializable {

    /**
     * 活动开始时间
     */
    private String activityBeginTime;

    /**
     * 活动结束时间
     */
    private String activityEndTime;

    /**
     * 活动主题
     */
    private String title;

    /**
     * 活动描述
     */
    private String desc;
}
