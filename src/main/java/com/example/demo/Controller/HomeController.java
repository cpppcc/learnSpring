package com.example.demo.Application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
public class HomeApplication {
    @GetMapping
    public String index(){
        return "/home";
    }

    @RequestMapping(method = RequestMethod.GET , value = "/page1")
    public String p1(){
        return "/page1";
    }
}
