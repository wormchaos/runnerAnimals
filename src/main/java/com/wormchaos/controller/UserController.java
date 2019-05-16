package com.wormchaos.controller;

import com.alibaba.fastjson.JSONObject;
import com.wormchaos.entity.User;
import com.wormchaos.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取用户权限
     * @return
     */
    @RequestMapping(value = "getUserInfo")
    public String getUserInfo() {
        Long userId = 17900684L;
        User user = userService.getUser(userId);
        return JSONObject.toJSONString(user);
    }

    /**
     * 获取用户权限
     * @return
     */
    @RequestMapping(value = "authorize")
    public String authorize() {
        return "test";
    }

    /**
     * 自动注册用户
     * @return
     */
    @RequestMapping(value = "register")
    public String register() {
        return "test";
    }


}
