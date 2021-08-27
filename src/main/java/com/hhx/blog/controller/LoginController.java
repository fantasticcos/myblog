package com.hhx.blog.controller;

import com.hhx.blog.pojo.User;
import com.hhx.blog.service.Imp.UserServiceImp;
import com.hhx.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class LoginController {
    @Autowired
    private UserServiceImp userService;
    @GetMapping
    public String userCheck()
    {
        return "admin/login";
    }
    @PostMapping(path = "/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes)
    {
        User u = new User(username,MD5Utils.code(password));
        if(userService.UserCheck(u)==1) {
            session.setAttribute("user",username);
            return "admin/index";
        }
        else {
            attributes.addFlashAttribute("message","检查用户名密码再登录");
            return "redirect:/admin";
        }


    }
    @GetMapping(path = "/signout")
    public String signout(HttpSession session)
    {
        session.removeAttribute("user");
        return "redirect:/admin";
    }


    //vue部分
    @GetMapping(path = "/vlogin")
    @ResponseBody
    public List<User> getall()
    {
        return userService.getall();
    }

}
