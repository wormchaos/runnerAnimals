package com.wormchaos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class TransportController {

    /**
     * 记录物流单号
     * @return
     */
    @RequestMapping(value = "wrtieTrackingNo")
    public String addTrackingNo() {
        // 鉴权 是否是起始节点用户
        // 记录起讫节点以及单号信息
        // 触发分配逻辑，给所有登录7天以上待分配用户分配路径，并且推送消息通知
        return "test";
    }

    /**
     * 添加用户地址
     * @return
     */
    @RequestMapping(value = "addAddress")
    public String addAddress() {
        return "test";
    }

    /**
     * 更改用户地址
     * @return
     */
    @RequestMapping(value = "updateAddress")
    public String updateAddress() {
        return "test";
    }

    /**
     * 导出传递列表
     * @return
     */
    @RequestMapping(value = "exportExcel")
    public String exportExcel() {
        return "test";
    }

}
