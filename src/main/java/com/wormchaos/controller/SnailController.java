package com.wormchaos.controller;

import com.wormchaos.dto.rsp.snail.SnailUserRsp;
import com.wormchaos.service.SnailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Raytine on 2021/1/23.
 */
@RestController
public class SnailController {

    @Resource
    private SnailService snailService;

    /**
     * 查询瓶娘当前所在地
     * @return
     */
    @RequestMapping(value = "getSnailUserStatus")
    public SnailUserRsp getSnailUserStatus(@RequestParam(defaultValue = "a") String openId ) {
        // 判断是否已入库用户
        SnailUserRsp user = snailService.getUserInfo(openId);
        // 已入库用户显示昵称以及物种分组
        return user;
    }

}
