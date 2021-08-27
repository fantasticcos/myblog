package com.hhx.blog.service;

import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Type;

import java.security.interfaces.DSAKeyPairGenerator;
import java.util.List;

public interface ITypeService {
    void save(Type type);
    Type getById(long id);
    List<Type> getlist(int i);
    Type getbyname(String name);
    void updatetype(Type type);
    void deletetype(long id);
    List<Type> getall();
    List<Type> getmorelistbyid();
    List<Blog> typeblog(Long id);
}
