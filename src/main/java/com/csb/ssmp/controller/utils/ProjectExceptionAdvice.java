package com.csb.ssmp.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cuilongyang
 * @createTime 2022/04/17
 */
// SpringMVC的异常处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception e){
        // 记录日志
        e.printStackTrace();
        return new R("服务器故障，请联系管理员");
    }
}
