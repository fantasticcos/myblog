package com.hhx.blog.dao;

import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Page;
import com.hhx.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ITypeDao {

    void save(Type type);
    Type getbyid(long id);
    List<Type> getlist(Page page);
    Type getbyname(String name);
    void updatetype(Type type);
    void deletetype(long id);
    List<Type> getall();
    List<Type> getmorelistbyid();
    List<Blog> typeblog(Long id);
}
