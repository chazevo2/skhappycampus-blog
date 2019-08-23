package com.example.blog.controller;

import com.example.blog.service.UserService;
import com.example.blog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @PostMapping("/register")
    public String createUser(User user) {
        User savedUser = service.save(user);

        return "redirect:tables";
    }
}
