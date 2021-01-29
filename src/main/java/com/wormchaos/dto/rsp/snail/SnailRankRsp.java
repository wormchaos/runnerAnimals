package com.wormchaos.dto.rsp.snail;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Raytine on 2021/1/29.
 */
@Data
public class SnailRankRsp implements Serializable {

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

    /**
     * 是否着重标记
     */
    private boolean isBold;

}
