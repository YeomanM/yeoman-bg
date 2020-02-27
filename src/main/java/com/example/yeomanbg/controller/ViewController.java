package com.example.yeomanbg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    @GetMapping("login")
    public String loginName() {
        return "login";
    }

    @GetMapping("login.jsp")
    public String loginJsp() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/mainFrame")
    public String mainFrame() {
        return "mainFrame";
    }

}
