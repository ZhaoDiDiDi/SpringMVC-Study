package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {

    //过滤器解决乱码
    @RequestMapping("/e/t")
    public String test1(Model model,String name) {
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }
}
