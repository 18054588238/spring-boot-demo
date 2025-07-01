package org.example.springbootdemo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
/*
* 拦截器
* */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果登录过，就放行：
        if (request.getSession().getAttribute("uname") != null) {
            return true;
        }
        // 如果没有登录过，先进行登录：(重定向)
        response.sendRedirect("login.html");
        return false;
    }
}
