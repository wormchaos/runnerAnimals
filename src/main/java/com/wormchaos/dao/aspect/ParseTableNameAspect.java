package com.wormchaos.dao.aspect;

import com.wormchaos.dao.utils.BaseDao;
import com.wormchaos.dao.utils.BaseProvider;
import org.apache.ibatis.binding.MapperProxy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Created by wormchaos on 2019-5-24.
 */
@Aspect
@Component
public class ParseTableNameAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(ParseTableNameAspect.class);

    @Around("execution(* com.wormchaos.dao.utils.BaseDao.*(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        parseTableName(proceedingJoinPoint);
        Object o = proceedingJoinPoint.proceed();
        BaseProvider.threadLocalRemove();

        return o;
    }


    private void parseTableName(ProceedingJoinPoint proceedingJoinPoint)
            throws NoSuchFieldException, IllegalAccessException,
            ClassNotFoundException {
        // 将modelClass添加到线程变量
        if (proceedingJoinPoint.getArgs() != null
                && proceedingJoinPoint.getArgs().length > 0) {
            BaseProvider.setModelClass(proceedingJoinPoint.getArgs()[0].getClass());
        } else {
            // 获取代理目标对象
            Field h = Proxy.class.getDeclaredField("h");
            h.setAccessible(true);
            Object proxyTarget = h.get(proceedingJoinPoint.getTarget());
            // 获取dao类
            Field mapperInterface = MapperProxy.class.getDeclaredField("mapperInterface");
            mapperInterface.setAccessible(true);
            Class<?> cl = (Class<?>) mapperInterface.get(proxyTarget);
            String modelName = null;
            // 因为是接口可能有多个
            Type[] types = cl.getGenericInterfaces();
            for (Type t : types) {
                // 只针对接口类型必须是BaseDao的
                ParameterizedType parameterizedType = (ParameterizedType) t;
                if (BaseDao.class.getClass().getName().equals(parameterizedType.getRawType().getClass().getName())) {
                    // 获取泛型类型
                    Type[] temp = parameterizedType.getActualTypeArguments();
                    for (Type c : temp) {
                        modelName = ((Class) c).getName();
                        LOGGER.info("当前操作实体对象:{}", modelName);
                    }
                    break;
                }
            }
            // 获取model类
            //String modelName = cl.getName().replace(".dao.", ".bean.").replace("Dao", "");
            BaseProvider.setModelClass(Class.forName(modelName));
        }
    }
}
