package com.hhx.blog;

import com.hhx.blog.dao.IUserDao;
import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Page;
import com.hhx.blog.pojo.Type;
import com.hhx.blog.pojo.User;
import com.hhx.blog.service.ITypeService;
import com.hhx.blog.service.Imp.BlogServiceImp;
import com.hhx.blog.service.Imp.TypeServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
//    @Autowired
//    private TypeServiceImp typeServiceImp;
    @Autowired
    private BlogServiceImp blogServiceImp;
    @Autowired
    private IUserDao dao;
    @Test
    void contextLoads() {

//        dao.login(new User("hello123","1234565"));
//        Type type = new Type();

        //type.setTid(10);type.setTname("测试数据2");
        Blog b = new Blog();
        b.setBtitle("M");
        b.setType(1);
        List<Blog> list = blogServiceImp.aboutsearch(b);
        for(Blog t :list)
        {
            System.out.println(t.toString());
        }
    }

}
