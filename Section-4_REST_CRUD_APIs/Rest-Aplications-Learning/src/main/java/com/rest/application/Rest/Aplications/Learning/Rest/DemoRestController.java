package com.rest.application.Rest.Aplications.Learning.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @RequestMapping("/")
    public String gethome(){
        return "Hello World";
    }

    @GetMapping("/home")
    public String home(){
        return ("Home Page");
    }

    @RequestMapping("/settings")
    public String Settings(){
        return "This is a settings Page!";
    }
}
