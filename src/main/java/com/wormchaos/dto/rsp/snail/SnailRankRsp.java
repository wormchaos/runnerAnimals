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
    private String force;
//
//    /**
//     * 排名
//     */
//    private String groupRank;

    /**
     * 所属分组
     */
    private String groupName;

    /**
     * 是否着重标记
     */
    private boolean isBold;

    /**
     * 是否已綁定
     */
    private boolean isBind;

}
