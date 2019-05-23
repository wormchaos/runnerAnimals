package com.wormchaos.dao;

import com.wormchaos.entity.Activity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wormchaos on 2019-5-23.
 */
public interface ActivityMapper {

    @Select("select * from t_activity")
    List<Activity> findAll();
}
