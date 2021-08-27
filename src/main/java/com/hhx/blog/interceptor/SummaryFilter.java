package com.hhx.blog.interceptor;

import com.hhx.blog.pojo.SiteMsg;
import com.hhx.blog.service.Imp.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SummaryFilter extends HandlerInterceptorAdapter {
    private UserServiceImp userServiceImp;
    public SummaryFilter(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("有获得网站基本信息吗");
        if(request.getSession().getAttribute("sitemsg")==null) {
//            response.sendRedirect("/init");
            SiteMsg msg = userServiceImp.sitemsg();
            request.getSession().setAttribute("sitemsg",msg);
        }

            return true;
    }
}
