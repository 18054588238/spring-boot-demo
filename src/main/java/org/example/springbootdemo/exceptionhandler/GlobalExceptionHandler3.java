package org.example.springbootdemo.exceptionhandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
* 处理异常 方式3
* 实现类
* */
public class GlobalExceptionHandler3 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        if (ex instanceof ArithmeticException) {
            mv.setViewName("error");
        }
        return mv;
    }
}
