package com.hhx.blog.controller;

import com.hhx.blog.pojo.Type;
import com.hhx.blog.service.Imp.TypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class TypeController {
    @Autowired
    private TypeServiceImp typeServiceImp;

    @GetMapping(path = "/types/{id}")
    public String list(@PathVariable Integer id , Model model)
    {
        List<Type> list = typeServiceImp.getlist(id);
        model.addAttribute("lists",list);
        model.addAttribute("page",id);
        return "/admin/types";
    }
    @GetMapping(path ="/types/input")
    public String addtype()
    {
        return "/admin/type-input";
    }
    @PostMapping(path = "/types")
    public String post(Type type, RedirectAttributes attributes)
    {
        Type type1 = typeServiceImp.getbyname(type.getTname());
        if(type1!=null)
        {
            attributes.addFlashAttribute("result","添加失败");
            return "redirect:/admin/types/1";
        }



        typeServiceImp.save(type);
        attributes.addFlashAttribute("result","添加成功");
        return "redirect:/admin/types/1";
    }

    @GetMapping(path = "/types/page/{id}")
    public String changepage(@PathVariable Integer id)
    {
        return "redirect:/admin/types/"+id;
    }
    @GetMapping(path = "/types/{id}/input")
    public String deleteType(@PathVariable Integer id,RedirectAttributes attributes)
    {
        attributes.addFlashAttribute("result","删除成功");
        try{
            typeServiceImp.deletetype(id);

        }catch (Exception e){
            attributes.addFlashAttribute("result","操作失败");
        }

        return "redirect:/admin/types/0";
    }

}
