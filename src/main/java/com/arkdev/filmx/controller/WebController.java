package com.arkdev.filmx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String registerPage(){
        return "register";
    }

    @GetMapping("/successful")
    public String homePage(){
        return "successful";
    }
}
