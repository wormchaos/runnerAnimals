package com.wormchaos.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Data
public class BaseReq implements Serializable {

    private static final long serialVersionUID = -6529439375374095091L;
    /**
     * 认证token
     */
    private String token;
}
