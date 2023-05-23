package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import javafx.beans.binding.Bindings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //目标资源方法运行前运行，返回true：放行，返回false：不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1.获取请求url
        String url = request.getRequestURI().toString();
        log.info("请求的url：{}", url);

        //2.判断请求url中是否包含直接放行的请求
        ArrayList<String> route = new ArrayList<String>();
        route.add("/wallpapers/all");
        route.add("/wallpapers/category");
        route.add("/wallpaper/search");
        route.add("/user/register");
        route.add("/login");
        route.add("/administratorlogin");

        for (int i = 0; i < route.size(); i++) {
            if (url.contains(route.get(i))) {
                log.info("不需要登录的操作，放行",route.get(i));
                return true;
            }

        }
        // 获取请求头中的令牌（token）
        String jwt = request.getHeader("token");

        //4.判断令牌是否存在，不存在：返回错误结果（未登录）
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换  对象--》json
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 5.解析token  如果解析失败，返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { //jwt解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        //6。放行
        log.info("令牌合法，放行");
        return true;
    }
    @Override // 目标资源放行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override //视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
