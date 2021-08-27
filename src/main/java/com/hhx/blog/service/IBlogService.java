package com.hhx.blog.service;

import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Comment;

import java.util.List;

public interface IBlogService {
    Blog getbyid(long id);
    List<Blog> getall();
    void addblog(Blog blog);
    void updateblog(Blog blog);
    void deleteblog(long id);
    List<Blog> aboutsearch(Blog blog);
    Blog getmorebyid(long id);
    void addcom(Comment comment);
    void addmcom(Comment comment);
    List<Comment> getallmcom();
    int totalnum();
    int leftmsgnum();
    int comnum();
}
