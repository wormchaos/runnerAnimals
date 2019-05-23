package com.wormchaos.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wormchaos on 2019-5-23.
 */
public class MyBeanUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(MyBeanUtils.class);

    public static <T> T copyProperties(Object source, Class<T> targetClazz) {
        T target;
        try {
            target = targetClazz.newInstance();
        } catch (Exception ex) {
            LOGGER.error("MyBeanUtils.copyProperties error", ex);
            return null;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> List copyPropertiesList(List<?> sourceList, Class<T> targetClazz) {
        List<T> list = new ArrayList<T>();
        T target;
        for (Object source : sourceList) {
            try {
                target = targetClazz.newInstance();
            } catch (Exception ex) {
                LOGGER.error("MyBeanUtils.copyProperties error", ex);
                return null;
            }
            BeanUtils.copyProperties(source, target);
            list.add(target);
        }
        return list;
    }
}
