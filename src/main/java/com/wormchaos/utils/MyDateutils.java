package com.wormchaos.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wormchaos on 2019-5-24.
 */
public class MyDateUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(MyDateUtils.class);

    public static final String DEFAULT_FORMATE = "yyyy-MM-dd HH:mm:ss";


    public static String format(Date date) {
        return format(date, DEFAULT_FORMATE);
    }

    public static String format(Date date, String format) {
        if(StringUtils.isEmpty(date)) {
            return null;
        }
        DateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date parse(String dateStr) {
        return parse(dateStr, DEFAULT_FORMATE);
    }

    public static Date parse(String dateStr, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException ex) {
            LOGGER.error("MyDateUtils parse", ex);
            return null;
        }
    }
}
