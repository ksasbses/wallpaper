package com.itheima.config;

import com.itheima.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;


@Configuration //配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> route = new ArrayList<String>();
        route.add("/register");
        route.add("/wallpapers/all");
        route.add("/wallpapers/category");
        route.add("/wallpaper/search");
        route.add("/login");
        route.add("/administratorlogin");


        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns(route);
    }
}
