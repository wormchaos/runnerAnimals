package com.wormchaos.dto.rsp;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raytine on 2021/1/27.
 */
@Data
public class BaseRsp<T> {

    private Integer code;

    private String desc;

    private List<T> data;

    public BaseRsp(Integer code) {
        this.code = code;
    }

    public BaseRsp(List<T> t) {
        this.setCode(1);
        this.setData(t);
    }

    public BaseRsp(T t) {
        this.setCode(1);
        List<T> list = new ArrayList<>();
        list.add(t);
        this.setData(list);
    }


    public static BaseRsp SUCCESS = new BaseRsp(1);
    public static BaseRsp FAILED = new BaseRsp(0);
}
