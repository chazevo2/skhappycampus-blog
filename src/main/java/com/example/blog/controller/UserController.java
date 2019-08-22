package com.example.blog.controller;

import com.example.blog.service.UserService;
import com.example.blog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
//    UserService service = new UserService();
    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<User> users() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id") int id) {
        return service.findUser(id);
    }

    @PostMapping("/users")
    public User join(String name) {
        return service.save(new User(null, name, new Date()));
    }

}
