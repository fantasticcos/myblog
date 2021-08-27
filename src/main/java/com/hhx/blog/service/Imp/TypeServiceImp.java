package com.hhx.blog.service.Imp;

import com.hhx.blog.dao.ITypeDao;
import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Page;
import com.hhx.blog.pojo.Type;
import com.hhx.blog.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImp implements ITypeService {
    @Autowired
    private Page page;

    @Autowired
    private ITypeDao dao;
    @Transactional
    @Override
    public void save(Type type) {
        dao.save(type);

    }
    @Override
    public Type getById(long id) {
        return dao.getbyid(id);
    }
    @Override
    public List<Type> getlist(int i) {
        page.init(i);
        return dao.getlist(page);
    }

    @Override
    public Type getbyname(String name) {
        return dao.getbyname(name);
    }

    @Override
    public void updatetype(Type type) {
         dao.updatetype(type);
    }

    @Override
    public void deletetype(long id) {
        dao.deletetype(id);
    }

    @Override
    public List<Type> getall() {
        return dao.getall();
    }

    @Override
    public List<Type> getmorelistbyid() {
        return dao.getmorelistbyid();
    }

    @Override
    public List<Blog> typeblog(Long id) {
        return dao.typeblog(id);
    }
}
