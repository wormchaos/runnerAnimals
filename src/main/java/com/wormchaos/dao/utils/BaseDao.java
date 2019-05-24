package com.wormchaos.dao.utils;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by wormchaos on 2019-5-23.
 */
public interface BaseDao<T> {

    @SelectProvider(type = BaseProvider.class, method = "getAll")
    List<T> getAll();
}
