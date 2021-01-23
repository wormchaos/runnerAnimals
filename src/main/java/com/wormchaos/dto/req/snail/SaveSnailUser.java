package com.wormchaos.dto.req.snail;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Raytine on 2021/1/23.
 */
@Data
public class SaveSnailUser implements Serializable {

    /**
     * 兵种强度
     */
    private Integer force;

    /**
     * 昵称
     */
    private String nickname;

}
