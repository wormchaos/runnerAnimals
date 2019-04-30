package com.wormchaos.utils.dto;

import lombok.Data;

/**
 * Created by wormchaos on 2019-4-30.
 */
@Data
public class DisPoint {

    /**
     * 经度
     * 0 - 180
     */
    private Double lon;

    /**
     * 纬度
     * 0 - 90
     */
    private Double lat;

}
