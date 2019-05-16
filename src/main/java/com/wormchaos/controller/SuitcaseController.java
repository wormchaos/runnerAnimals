package com.wormchaos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wormchaos on 2019-5-16.
 */
@RestController
public class SuitcaseController {

    /**
     * 查询瓶娘当前所在地
     * @return
     */
    @RequestMapping(value = "getCurrentNode")
    public String getCurrentNode() {
        return "test";
    }

    /**
     * 查询我的瓶娘记录点
     * @return
     */
    @RequestMapping(value = "getMyNodeList")
    public String getMyNodeList() {
        // 可能会出现同一个用户多处的场景
        return "test";
    }

    /**
     * 查询瓶娘路线
     * @return
     */
    @RequestMapping(value = "getRouteList")
    public String getRouteList() {
        return "test";
    }

    /**
     * 根据nodeId获取当前节点信息
     * @return
     */
    @RequestMapping(value = "getNodeDetail")
    public String getNodeDetail() {
        return "test";
    }

    /**
     * 记录日记byNode
     * @return
     */
    @RequestMapping(value = "writeNote")
    public String writeNote() {
        // 校验用户权限:是否是当前节点用户
        // 参数校验
        // 是否存在，已存在则update
        // 入库
        return "test";
    }

    /**
     * 根据nodeId查询日记
     * @return
     */
    @RequestMapping(value = "checkNote")
    public String checkNote() {
        return "test";
    }


}
