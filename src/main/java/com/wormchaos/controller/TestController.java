package com.wormchaos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wormchaos on 2019-4-30.
 */
@RestController
public class TestController {

    @Value("${test}")
    private String test;

//    @Value("${spring.profile.active}")
//    private String version;

    @Value("${spring.datasource.url}")
    private String url;

    @RequestMapping(value = "test")
    public String test() {
        return url;
    }

}
