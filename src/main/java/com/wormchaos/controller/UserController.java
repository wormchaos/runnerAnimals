package com.wormchaos.controller;

import com.alibaba.fastjson.JSONObject;
import com.wormchaos.entity.User;
import com.wormchaos.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 获取用户权限
     * @return
     */
    @GetMapping
    public String getUserInfo() {
        Long userId = getUserId();
        User user = userService.getUser(userId);
        return JSONObject.toJSONString(user);
    }

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(value = "getUserList")
    public String getUserList() {
        List<User> user = userService.getUserList();
        return JSONObject.toJSONString(user);
    }

    /**
     * 认证
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
