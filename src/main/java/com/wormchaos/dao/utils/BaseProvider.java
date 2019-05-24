package com.wormchaos.dao.utils;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.cglib.core.ReflectUtils;

import javax.persistence.Table;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


/**
 * Created by wormchaos on 2019-5-23.
 */
public class BaseProvider<T> {

    /**
     * 当前类
     */
    private Class<?> modelClazz;

    /**
     * 当前类
     */
    private static ThreadLocal<Class<?>> threadModelClass = new ThreadLocal<>();

    /**
     * 表名
     */
    private String tableName;

    /**
     * 非通用的demo
     *
     * @param para
     * @return
     */
    @Deprecated
    public String demoSelect(Map<String, Object> para) {
        return new SQL() {{
            SELECT("*");
            FROM("t_user");
            WHERE("id=" + para.get("id"));
        }}.toString();
    }

    /**
     * sql-查询全部列表
     * @return
     */
    public String getAll() {
        // 初始化参数
        initTable();
        SQL sql = SELECT_FROM();
        return sql.toString();
    }

    /**
     * sql-插入
     * @param t
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchFieldException
     */
    public String insert(final T t) throws IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        initTable();
        // 设置默认值
        SQL sql = INSERT();
        return sql.toString();
    }

    private SQL INSERT() {
        SQL sql = new SQL() {
            {
                INSERT_INTO(tableName);
                PropertyDescriptor[] propDescriptors = ReflectUtils.getBeanSetters(modelClazz);
                for (PropertyDescriptor propertyDescriptor : propDescriptors) {
                    String name = propertyDescriptor.getName();
                    String columnName = convertColumnName(name);

                    // 过滤不允许更新的字段
                    if (null == name) {
                        continue;
                    }
                    VALUES(columnName, "#{" + name + "}");

                }

            }
        };
        return sql;
    }

    /**
     * 初始化
     */
    private void initTable() {
        // 获取泛型class
        this.modelClazz = BaseProvider.threadModelClass.get();
        // 获取表名
        this.tableName = modelClazz.getAnnotation(Table.class).name();
    }

    /**
     * 拼接mybatis的select_from
     *
     * @return
     */
    private SQL SELECT_FROM() {
        // 反射取modelClazz的元素
        PropertyDescriptor[] propDescriptors = ReflectUtils.getBeanSetters(modelClazz);

        return new SQL() {
            {
                for (PropertyDescriptor propertyDescriptor : propDescriptors) {
                    String columnName = convertColumnName(propertyDescriptor.getName());
                    SELECT(columnName);
                }
                FROM(tableName);
            }
        };
    }


    public static void setModelClass(Class<?> modelClass) {
        BaseProvider.threadModelClass.set(modelClass);
    }


    public static void threadLocalRemove() {
        if (BaseProvider.threadModelClass != null) {
            BaseProvider.threadModelClass.remove();
        }
    }



    private String convertColumnName(String name) {
        if(null == name) {
            return null;
        }
        return name.replaceAll("([A-Z])", "_$0").toUpperCase();
    }
}
