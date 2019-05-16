package com.wormchaos.dto.req;

import lombok.Data;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Data
public class JoinActivityReq extends BaseReq {

    /**
     * 活动id
     */
    private Long activityId;
}
