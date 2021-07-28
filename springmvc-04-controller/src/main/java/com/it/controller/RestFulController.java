package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

//    @RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)        //方式一
    @GetMapping("/add/{a}/{b}")                                                                               //方式二
    public String test1(@PathVariable int a,@PathVariable int b, Model model){
        //@PathVariable 注解，让方法参数的值对应绑定到一个URI模板变量上。
        int result = a + b;
        model.addAttribute("msg", "结果为："+ result);
        return "test";
    }
}
