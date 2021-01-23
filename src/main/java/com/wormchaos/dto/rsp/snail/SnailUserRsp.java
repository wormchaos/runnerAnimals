package com.wormchaos.dto.rsp.snail;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Raytine on 2021/1/23.
 */
@Data
public class SnailUserRsp implements Serializable {

    /**
     * 用户状态
     * 0-未注册 1-已注册
     */
    private Integer status;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 兵种强度
     */
    private Integer force;

    /**
     * 排名
     */
    private Integer groupRank;

    /**
     * 所属分组
     */
    private String groupName;

}
