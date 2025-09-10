package com.thymeleaf.demo.ThymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }
    @GetMapping("/")
    public String home(Model theModel){
        return "home";
    }
}
