package com.example.yeomanbg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping
    public String login() {
        return "login";
    }

    @GetMapping("login")
    public String loginName() {
        return "login";
    }

    @GetMapping("login.jsp")
    public String loginJsp() {
        return "login";
    }


}
