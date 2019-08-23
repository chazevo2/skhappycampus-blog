package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/tables")
    public String tables() {
        return "tables";
    }
}
