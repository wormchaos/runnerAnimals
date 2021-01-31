package com.wormchaos.controller;

import com.wormchaos.controller.exception.MyException;
import com.wormchaos.dto.rsp.BaseRsp;
import com.wormchaos.service.UserService;
import com.wormchaos.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Raytine on 2021/1/28.
 */
@RestController
@Slf4j
public class WechatController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 微信登陆
     * @return
     */
    @RequestMapping(value = "wechatLogin")
    public BaseRsp wechatLogin(@RequestParam String code) {
        String openId = null;
        try {
            openId = HttpUtils.getOpenId(code);
        } catch (IOException e) {
            log.error("获取openId失败", e);
            return BaseRsp.FAILED;
        }
        if (null == openId) {
            BaseRsp rsp = BaseRsp.FAILED;
            rsp.setDesc("请勿重复提交");
            return rsp;
        }
        // 保存openId
        String token = userService.userLogin(code, openId);
        BaseRsp rsp = BaseRsp.SUCCESS;
        rsp.setToken(token);
        return rsp;
    }

    /**
     * 检查登陆
     * @return
     */
    @RequestMapping(value = "checkLogin")
    public BaseRsp checkLogin(@RequestParam String token) {
        getUserIdWithCheck(token);
        return BaseRsp.SUCCESS;
    }
}
