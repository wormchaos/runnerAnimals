package com.wormchaos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwenqiang on 2019-4-30.
 */
@RestController
public class TestController {

    @RequestMapping(value = "test")
    public String test() {
        return "test";
    }

}
