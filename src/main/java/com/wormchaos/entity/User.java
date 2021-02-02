package com.wormchaos.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * Created by wormchaos on 2019-5-16.
 */
@Data
@Table(name = "t_user")
public class User {

//    /**
//     * 用户手机号
//     */
//    private String phone;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 微信openId
     */
    private String openId;

//    /**
//     * 昵称
//     */
//    private String nickname;
//
//    /**
//     * 兵种强度
//     */
//    private Integer armForce;

    /**
     * 是否允许消息推送
     */
    private Integer allowMessage;

}
