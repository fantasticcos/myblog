package com.hhx.blog.service;

import com.hhx.blog.pojo.SiteMsg;
import com.hhx.blog.pojo.User;

import java.util.List;

public interface IUserService {
    int UserCheck(User user);
    List<User> getall();
    SiteMsg sitemsg();
}
