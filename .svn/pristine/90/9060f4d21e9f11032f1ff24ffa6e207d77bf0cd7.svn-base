package com.yangjiayu.config;

import com.yangjiayu.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 86188 on 2019/8/14.
 */

@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        List<String> list = new ArrayList();
        list.add("/js/**");
        list.add("/css/**");
        list.add("/images/**");
        list.add("/bootstrap3/**");
        list.add("/web/login.html");
        list.add("/web/register.html");
        list.add("/users/login");
        list.add("/users/reg");
        list.add("/product/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(list);
    }
}
