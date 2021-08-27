package com.hhx.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Comment;
import com.hhx.blog.pojo.Type;
import com.hhx.blog.service.Imp.BlogServiceImp;
import com.hhx.blog.service.Imp.TypeServiceImp;
import com.hhx.blog.utils.MdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/blogs")
public class VBlogController {
    @Autowired
    private BlogServiceImp blogServiceImp;
    @Autowired
    private TypeServiceImp serviceImp;


    @GetMapping(path = "/{id}")
    public String showdetail(@PathVariable Long id, Model model)
    {

        Blog blog = blogServiceImp.getmorebyid(id);
        System.out.println(blog.toString());
        blog.setBview(blog.getBview()+1);
        blogServiceImp.updateblog(blog);
        String res=null;
        if(blog.getBcontent()!=null)
        res = MdUtils.mdToHtmlExt(blog.getBcontent());

        List<Comment> list = blog.getComments();
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
        }
        blog.setBcontent(res);
        if(blog!=null)
        model.addAttribute("blog",blog);
        else
            model.addAttribute("msg","没有数据");
        return "/text";
    }
    @RequestMapping(path = "/viewonblog")
    public String comment(Comment comment,Model model )
    {
        System.out.println(comment.toString());
//        if(comment.getLoc()==-1)
//            comment.setLoc(comment.getCid());
        blogServiceImp.addcom(comment);
        Blog blog = blogServiceImp.getmorebyid(comment.getBid());
        List<Comment> list = blog.getComments();
        Map<Long,Comment> map = new HashMap<>();
        for(Comment c : list)
        {
            map.put(c.getCid(),c);
        }
//        Map<Long ,List<Comment>> filiter = new HashMap<>();//将所有相同parentid的放到一个list里面
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

//        for(Comment c :list)
//        {
//                if(filiter.containsKey(c.getLoc()))//存在父级评论容器
//                {
//                    filiter.get(c.getLoc()).add(c);
//
//                }
//        }

        if(blog!=null)
            model.addAttribute("blog",blog);

        System.out.println("???");

        return "/text :: commentlist";
    }

    @GetMapping(path = "/type/{id}")//类别分类展示博客
    public String detailtype(@PathVariable Long id,@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model)
    {
        PageHelper.startPage(pagenum,2);
//        Type type = serviceImp.getmorelistbyid(id);
        List<Blog> list =serviceImp.typeblog(id);
        PageInfo pageInfo = new PageInfo(list);
//        model.addAttribute("type",type);
        List<Type> tlist = serviceImp.getmorelistbyid();
        model.addAttribute("typelist",tlist);
        model.addAttribute("type",id);
        model.addAttribute("page",pageInfo);
        return "/types";
    }


}
