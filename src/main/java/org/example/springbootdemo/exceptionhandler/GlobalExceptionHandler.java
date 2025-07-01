package org.example.springbootdemo.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*
* 用的最多
* */
@ControllerAdvice // 加了这个注解，代表当前类是  异常处理类
public class GlobalExceptionHandler {
    // 处理异常--出现算数异常时进行以下处理
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public String myExceptionHandler() {
        System.out.println("异常处理逻辑代码--全局");
        return "error";
    }
}
