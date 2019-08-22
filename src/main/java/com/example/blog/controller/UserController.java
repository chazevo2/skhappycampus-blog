package com.example.blog.controller;

import com.example.blog.exception.UserNotFoundException;
import com.example.blog.service.UserService;
import com.example.blog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
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
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        User deletedUser = service.deleteById(id);

        if (deletedUser == null) {
            throw new UserNotFoundException("id : " + id);
        }
    }

    @PutMapping("/users/{id}")
    public User modifyUser(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        User modifiedUser = service.edit(user);

        if (modifiedUser == null) {
            throw new UserNotFoundException("id : " + id);
        }
        return modifiedUser;
    }

}
