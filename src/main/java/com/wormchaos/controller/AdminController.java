package com.wormchaos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class AdminController {

    @RequestMapping(value = "addNewActivity")
    public String addNewActivity() {
        // 验证用户是否有发起权限
        return "test";
    }

    /**
     * 开启活动
     * @return
     */
    @RequestMapping(value = "activeActivity")
    public String activeActivity() {
        // 验证用户是否有发起权限
        return "test";
    }

    /**
     * 中止活动
     * @return
     */
    @RequestMapping(value = "abortActivity")
    public String abortActivity() {
        // 验证用户是否有发起权限
        return "test";
    }

}
