package org.example.springbootdemo.config;

import org.example.springbootdemo.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 注册拦截器
* */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    //配置拦截器的映射
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有路径
        // 但是对：login.html放行，向后台提交login的时候放行。
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/login.html","/css/**","/js/**","/images/**");//静态资源也放行
    }
}
