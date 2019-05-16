package com.wormchaos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class ActivityController {

    /**
     * 加入活动
     * @return
     */
    @RequestMapping(value = "joinActivity")
    public String joinActivity() {
        // 校验地址有效性
        // 记录用户信息
        return "test";
    }

    /**
     * 获取活动列表
     * @return
     */
    @RequestMapping(value = "getActivityList")
    public String getActivityList() {
        return "test";
    }
}
