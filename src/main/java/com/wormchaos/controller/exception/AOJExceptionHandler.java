package com.wormchaos.controller.exception;

import com.wormchaos.dto.rsp.BaseRsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Raytine on 2021/1/27.
 */

@ControllerAdvice
public class AOJExceptionHandler {

    Logger LOGGER = LoggerFactory.getLogger(AOJExceptionHandler.class);

    @ExceptionHandler(value={MyException.class})
    @ResponseBody
    public BaseRsp arithmeticExceptionHandle(MyException e) {
        LOGGER.info("系统异常抛出", e);
        BaseRsp mv = BaseRsp.FAILED;
        mv.setDesc(e.getMsg());
        return mv;
    }
    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    public BaseRsp arithmeticExceptionHandle(Exception e) {
        LOGGER.info("系统异常抛出", e);
        BaseRsp mv = BaseRsp.FAILED;
        mv.setDesc("系统报错");
        return mv;
    }
}
