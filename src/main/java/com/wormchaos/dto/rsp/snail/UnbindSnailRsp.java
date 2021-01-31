package com.wormchaos.dto.rsp.snail;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Raytine on 2021/1/29.
 */
@Data
public class UnbindSnailRsp implements Serializable {

    private Long bindId;

    private String nickname;
}
