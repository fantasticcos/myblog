package com.hhx.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhx.blog.hadler.NotfoundException;
import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Comment;
import com.hhx.blog.pojo.Type;
import com.hhx.blog.service.Imp.BlogServiceImp;
import com.hhx.blog.service.Imp.TypeServiceImp;
import com.hhx.blog.service.Imp.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Webcontroller {
    public static int num=0;
    @Autowired
    private BlogServiceImp blogServiceImp;
    @Autowired
    private TypeServiceImp typeServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @RequestMapping(path = "/")
    public String index(HttpSession session, Model model)
    {
//        int a=9/0;
//        if (1==1)
//        throw new NotfoundException("找不到");
        String path = session.getServletContext().getRealPath("");


        return "redirect:/index";
    }
    @RequestMapping(path = "/init")
    public ModelAndView init(HttpSession session)
    {
        session.setAttribute("sitemsg",userServiceImp.sitemsg());
        return null;
    }
    @RequestMapping(path = "/game")
    public String plygame()
    {
        return "game";
    }
    @RequestMapping(path = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        return "admin/login";
    }
    @RequestMapping(path = "/index")
    public String getindex(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model,HttpSession session)
    {
        PageHelper.startPage(pagenum,2);
        List<Blog> lists  =blogServiceImp.getall();
        PageInfo pageInfo = new PageInfo(lists);

        model.addAttribute("page",pageInfo);
        model.addAttribute("nums",num+1);
        return "index";
    }
    @RequestMapping(path = "/about")
    public String getabout()
    {
        return "about";
    }
    @RequestMapping(path = "/archives")
    public String getarchives()
    {
        return "archives";
    }

    @RequestMapping(path = "/message")
    public String getmessage(Model model)
    {
        List<Comment> list = blogServiceImp.getallmcom();
        Map<Long,Comment> map = new HashMap<>();
        for(Comment c : list)
        {
            map.put(c.getCid(),c);
        }
        for(Comment c : list)
        {
            if(c.getParentid()!=-1) {
                Comment f = new Comment();
                f.setCnickname(map.get(c.getParentid()).getCnickname());
                c.setFather(f);
            }
//            if(c.getParentid()==-1)
//            {
//                filiter.put(c.getCid(),new ArrayList<>());
//            }
        }
        model.addAttribute("list",list);
        return "message";
    }
    @RequestMapping(path = "/types")
    public String gettypes(Model model)
    {
        PageHelper.startPage(1,2);
        List<Blog> list =blogServiceImp.getall();
        PageInfo pageInfo = new PageInfo(list);
        List<Type> tlist = typeServiceImp.getmorelistbyid();
        model.addAttribute("typelist",tlist);
        model.addAttribute("page",pageInfo);
        return "types";
    }
    @RequestMapping(path = "/text")
    public String test()
    {
        return "text";
    }
    @RequestMapping(path = "/message/view")
    public String mcom(Comment comment,Model model)
    {
        blogServiceImp.addmcom(comment);
        List<Comment> list =blogServiceImp.getallmcom();
        Map<Long,Comment> map = new HashMap<>();
        for(Comment c : list)
        {
            map.put(c.getCid(),c);
        }
        for(Comment c : list)
        {
            if(c.getParentid()!=-1) {
                Comment f = new Comment();
                f.setCnickname(map.get(c.getParentid()).getCnickname());
                c.setFather(f);
            }
//            if(c.getParentid()==-1)
//            {
//                filiter.put(c.getCid(),new ArrayList<>());
//            }
        }
        model.addAttribute("list",list);
        return "/message :: commentlist";
    }
}
