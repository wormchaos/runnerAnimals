package com.wormchaos.controller;

import com.wormchaos.controller.exception.MyException;
import com.wormchaos.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wormchaos on 2019-5-24.
 */
@Controller
public class BaseController {

    @Resource
    private UserService userService;

    /**
     * 获取userId
     * @return
     */
    protected String getOpenIdByToken(String token) {
        return userService.getOpenIdByToken(token);
    }

    protected Long getUserId(String token) {
        Long userId = null;
        String openId = getOpenIdByToken(token);
        if (null != openId) {
            userId = userService.getUserIdByOpenId(openId);
        }
        return userId;
    }

    protected Long getUserIdWithCheck(String token) {
        String openId = getOpenIdByToken(token);
        if (null != openId) {
            return userService.getUserIdByOpenId(openId);
        }
        throw new MyException("用户未登陆");
    }


}
