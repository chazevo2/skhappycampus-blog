package com.example.blog.controller;

import com.example.blog.service.UserService;
import com.example.blog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/tables")
    public ModelAndView tables() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("tables");

        List<User> userList = service.findAll();
        mav.addObject("users", userList);
        return mav;
    }
}
