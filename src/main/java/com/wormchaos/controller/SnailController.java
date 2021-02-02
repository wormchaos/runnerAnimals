package com.wormchaos.controller;

import com.wormchaos.dto.req.snail.SaveSnailUser;
import com.wormchaos.dto.rsp.BaseRsp;
import com.wormchaos.dto.rsp.snail.SnailRankRsp;
import com.wormchaos.dto.rsp.snail.SnailUserRsp;
import com.wormchaos.dto.rsp.snail.UnbindSnailRsp;
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
public class SnailController extends BaseController {

    @Resource
    private SnailService snailService;

    /**
     * 获取当前用户资料
     *
     * @return
     */
    @RequestMapping(value = "getSnailUserStatus")
    public BaseRsp<SnailUserRsp> getSnailUserStatus(@RequestParam String token) {
        Long userId = getUserIdWithCheck(token);
        SnailUserRsp user = snailService.getUserInfo(userId);
        // 已入库用户显示昵称以及物种分组
        BaseRsp result = new BaseRsp(user);
        return result;
    }

    /**
     * 允许用户推送消息
     *
     * @return
     */
    @RequestMapping(value = "allowMessage")
    public BaseRsp allowMessage(@RequestParam String token, @RequestParam(defaultValue = "0") Integer allowMessage) {
        Long userId = getUserIdWithCheck(token);
        snailService.allowMessage(userId, allowMessage);
        return BaseRsp.SUCCESS;
    }

    // 统一用绑定的方式
//    /**
//     * 报错用户资料
//     * @return
//     */
//    @RequestMapping(value = "saveUser")
//    public BaseRsp saveUser(@RequestBody SaveSnailUser user, @RequestParam String code) {
//        // 判断是否已入库用户
//        snailService.saveSnailUser(user, code);
//        // 已入库用户显示昵称以及物种分组
//        return BaseRsp.SUCCESS;
//    }


    /**
     * 允许用户推送消息
     *
     * @return
     */
    @RequestMapping(value = "batchSendMessage")
    public BaseRsp batchSendMessage(@RequestParam String code) {
        if (code.equals("1ASDAS1WZ")) {
            snailService.batchSendMessage();
        }
        return BaseRsp.SUCCESS;
    }

    /**
     * 更新兵种战力
     * @param user
     * @param token
     * @return
     */
    @RequestMapping(value = "updateForce")
    public BaseRsp updateForce(@RequestBody SaveSnailUser user, @RequestParam(required = false) String token) {
        Long userId = getUserIdWithCheck(token);
        snailService.updateForce(user, userId);
        return BaseRsp.SUCCESS;
    }

    /**
     * 获取当前用户资料
     *
     * @return
     */
    @RequestMapping(value = "getRankList")
    public BaseRsp<SnailRankRsp> getRankList(@RequestParam(required = false) String token) {
        Long userId = getUserIdWithCheck(token);
        List<SnailRankRsp> rankList = snailService.getRankListByGroupId(userId, 1);
        BaseRsp<SnailRankRsp> rsp = BaseRsp.SUCCESS;
        rsp.setData(rankList);
        // 已入库用户显示昵称以及物种分组
        return rsp;
    }

    /**
     * 获取未绑定用户信息
     *
     * @return
     */
    @RequestMapping(value = "getUnbindUserList")
    public BaseRsp<UnbindSnailRsp> getUnbindUserList(@RequestParam(required = false) String token, @RequestParam(defaultValue = "1") Integer groupId) {
        getUserIdWithCheck(token);
        List<UnbindSnailRsp> rankList = snailService.getUnbindUserList(groupId);
        BaseRsp<UnbindSnailRsp> rsp = BaseRsp.SUCCESS;
        rsp.setData(rankList);
        return rsp;
    }

    /**
     * 绑定蜗牛账号
     *
     * @return
     */
    @RequestMapping(value = "bindSnail")
    public BaseRsp bindSnail(@RequestParam String token, @RequestParam Long bindId) {
        Long userId = getUserIdWithCheck(token);
        // 绑定用户
        snailService.bindSnail(userId, bindId);
        return BaseRsp.SUCCESS;
    }

}
