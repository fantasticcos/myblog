package com.hhx.blog.service.Imp;

import com.hhx.blog.dao.IBlogDao;
import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Comment;
import com.hhx.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImp implements IBlogService {
    @Autowired
    private IBlogDao dao;
    @Override
    public Blog getbyid(long id) {
        return dao.getbyid(id);
    }

    @Override
    public List<Blog> getall() {
        return dao.getall();
    }

    @Override
    public void addblog(Blog blog) {
        dao.addblog(blog);
    }

    @Override
    public void updateblog(Blog blog) {
        dao.updateblog(blog);
    }

    @Override
    public void deleteblog(long id) {
        dao.deleteblog(id);
    }

    @Override
    public List<Blog> aboutsearch(Blog blog) {
        return dao.aboutsearch(blog);
    }

    @Override
    public Blog getmorebyid(long id) {
        return dao.getmorebyid(id);
    }

    @Override
    public void addcom(Comment comment) {
        dao.addcom(comment);
    }

    @Override
    public void addmcom(Comment comment) {
        dao.addmcom(comment);
    }

    @Override
    public List<Comment> getallmcom() {
        return dao.getallmcom();
    }

    @Override
    public int totalnum() {
        return dao.totalnum();
    }

    @Override
    public int leftmsgnum() {
        return dao.leftmsgnum();
    }

    @Override
    public int comnum() {
        return dao.comnum();
    }
}
