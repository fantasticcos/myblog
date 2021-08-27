package com.hhx.blog.dao;

import com.hhx.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface IUserDao {
    int login(User user);
    List<User> getall();
    Timestamp getbegintime();
}
