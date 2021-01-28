package com.wormchaos.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * Created by Raytine on 2021/1/28.
 */
@Data
@Table(name = "t_snail")
public class Snail {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 公会id
     */
    private Long groupId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 兵种强度
     */
    private Integer armForce;
}
