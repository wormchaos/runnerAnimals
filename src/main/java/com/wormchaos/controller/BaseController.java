package com.wormchaos.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wormchaos on 2019-5-24.
 */
@Controller
public class BaseController {

    /**
     * 获取userId
     * @return
     */
    protected Long getUserId() {
        return randomUserId();
    }

    private Long randomUserId() {
        return (long) (Math.random() * 10000);
    }

}
