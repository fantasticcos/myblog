package com.hhx.blog.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("拦截了咩？");
        if(request.getSession().getAttribute("user")==null) {
            response.sendRedirect("/admin");
            return false;
        }
        else
            return true;

    }
}
