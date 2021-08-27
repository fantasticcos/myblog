package com.hhx.blog.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhx.blog.pojo.Blog;
import com.hhx.blog.pojo.Type;
import com.hhx.blog.service.Imp.BlogServiceImp;
import com.hhx.blog.service.Imp.TypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class BlogController {
    @Autowired
    private TypeServiceImp typeServiceImp;
    @Autowired
    private BlogServiceImp blogServiceImp;
    @RequestMapping (path = "/blogadmin")
    public String getblog(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model,Blog blog)
    {

        PageHelper.startPage(pagenum,5);
        List<Blog> lists  =blogServiceImp.aboutsearch(blog);
        PageInfo pageInfo = new PageInfo(lists);
        List<Type> l = typeServiceImp.getall();
        model.addAttribute("page",pageInfo);
        model.addAttribute("typelist",l);
        return "/admin/blog";
    }
    @GetMapping(path = "/blogs/input")
    public String input(Model model)
    {
        List<Type> list = typeServiceImp.getall();
        model.addAttribute("typelist",list);
        return "/admin/blog-input";
    }
    @PostMapping(path = "/blogs")
    public String addblog(Blog blog, RedirectAttributes attributes)
    {
        blogServiceImp.addblog(blog);
        attributes.addFlashAttribute("result","添加成功");
        return "redirect:/admin/blogadmin";
    }
    @GetMapping(path = "/blogs/remove/{id}")
    public String deleteblog(@PathVariable Long id,RedirectAttributes attributes)
    {
        try{
            blogServiceImp.deleteblog(id);
        }
        catch(Exception e)
        {
            attributes.addFlashAttribute("result","删除失败");
            return "redirect:/admin/blogadmin";
        }
        attributes.addFlashAttribute("result","删除成功");
        return "redirect:/admin/blogadmin";

    }
    @GetMapping(path = "/blogs/up/{id}")
    public String upblog(@PathVariable Long id,Model model)
    {
        Blog blog = blogServiceImp.getbyid(id);
        model.addAttribute("blog",blog);
        return "/admin/blog-up";
    }
    @PostMapping(path = "/blogs/update")
    public String uupblog(Blog blog)
    {
        try{
            blogServiceImp.updateblog(blog);
        }catch (Exception e)
        {
            System.out.println("更新博客失败");
        }

        return "/admin/blogadmin";
    }


}
