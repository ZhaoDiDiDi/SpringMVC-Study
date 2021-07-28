package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

    @RequestMapping("/redirect/t1")
    public String test1(){
        //重定向  不走视图解析器
        return "redirect:/index.jsp";
    }

    @RequestMapping("/forward/t1")
    public String test2(Model model){
        //转发
        model.addAttribute("msg", "转发");
        return "test";
    }
}
