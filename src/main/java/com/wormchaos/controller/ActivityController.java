package com.wormchaos.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wormchaos.dto.req.JoinActivityReq;
import com.wormchaos.dto.rsp.ActivityRsp;
import com.wormchaos.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class ActivityController {

    private Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);

    @Resource
    private ActivityService activityService;

    /**
     * 加入活动
     * @return
     */
    @RequestMapping(value = "joinActivity")
    public String joinActivity(@RequestBody JoinActivityReq req) {
        // 校验地址有效性
        // 记录用户信息
        LOGGER.info("joinActivity, req {}", JSONObject.toJSONString(req));
        return "test";
    }

    /**
     * 获取活动列表
     * @return
     */
    @RequestMapping(value = "getActivityList")
    public List<ActivityRsp> getActivityList() {
        Long userId = 11L;
        List<ActivityRsp> rsp = activityService.getActivityList(userId);
        return rsp;
    }
}
