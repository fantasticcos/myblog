package com.hhx.blog.interceptor;

import com.hhx.blog.service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class FilterConfig implements WebMvcConfigurer {
    @Autowired
    private UserServiceImp userServiceImp;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/vlogin");
        registry.addInterceptor(new SummaryFilter(userServiceImp))
                .addPathPatterns("/**");


    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST","GET")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
