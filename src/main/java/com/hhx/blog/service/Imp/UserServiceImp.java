package com.hhx.blog.service.Imp;

import com.hhx.blog.dao.IBlogDao;
import com.hhx.blog.dao.IUserDao;
import com.hhx.blog.pojo.SiteMsg;
import com.hhx.blog.pojo.User;
import com.hhx.blog.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IBlogDao blogDao;
    @Override
    public int UserCheck(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> getall() {
        return userDao.getall();
    }

    @Override
    public SiteMsg sitemsg() {
        int blognum = blogDao.totalnum();
        int comnum = blogDao.comnum();
        int leftmsgnum = blogDao.leftmsgnum();
        Timestamp timestamp = userDao.getbegintime();
        String p2 = null;
        ClassPathResource pathResource = new ClassPathResource("record.txt");
//        try {
//            p2 = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath()+"record.txt";
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Logger logger = LoggerFactory.getLogger(this.getClass());
//        File file = new File(p2);
        OutputStream out = null;

//
//        try {
//            in = new FileInputStream(file);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(pathResource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int num = 999;
        try {
            logger.info("获取前为："+num);
            num = Integer.parseInt(reader.readLine()+"")+1;
            logger.info("获取后为："+num);


            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out = new FileOutputStream(pathResource.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        try {
            writer.write(num+"");
            writer.flush();
            writer.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SiteMsg msg  = new SiteMsg();
        msg.setComnum(comnum);
        msg.setLeftmsgnum(leftmsgnum);
        msg.setTotalnum(blognum);
        msg.setVisitnum(num);
        msg.setDuration(timestamp.toLocalDateTime());
        return msg;
    }
}
