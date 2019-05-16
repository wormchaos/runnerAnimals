package com.wormchaos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class UserController {

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
