package com.wormchaos.controller;

import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.dto.rsp.BaseRsp;
import com.wormchaos.dto.rsp.snail.SnailRankRsp;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;
import com.wormchaos.service.SnailService;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raytine on 2021/1/23.
 */
@RestController
public class SnailController {

    @Resource
    private SnailService snailService;

    /**
     * 获取当前用户资料
     * @return
     */
    @RequestMapping(value = "getSnailUserStatus")
    public BaseRsp<SnailUserRsp> getSnailUserStatus(@RequestParam String code) {
        // 判断是否已入库用户
        SnailUserRsp user = snailService.getUserInfo(code);
        // 已入库用户显示昵称以及物种分组
        BaseRsp result = new BaseRsp(user);
        return result;
    }

    /**
     * 获取当前用户资料
     * @return
     */
    @RequestMapping(value = "saveUser")
    public BaseRsp saveUser(@RequestBody SaveSnailUser user, @RequestParam String code) {
        // 判断是否已入库用户
        snailService.saveSnailUser(user, code);
        // 已入库用户显示昵称以及物种分组
        return BaseRsp.SUCCESS;
    }

    /**
     * 获取当前用户资料
     * @return
     */
    @RequestMapping(value = "getRankList")
    public BaseRsp<SnailRankRsp> getRankList(@RequestParam(required = false) String code) {
        // 判断是否已入库用户
        List<SnailRankRsp> rankList = snailService.getRankListByGroupId(code, 1);
        BaseRsp<SnailRankRsp> rsp = BaseRsp.SUCCESS;
        rsp.setData(rankList);
        // 已入库用户显示昵称以及物种分组
        return rsp;
    }

}
