package com.example.blog.controller;

import com.example.blog.exception.UserNotFoundException;
import com.example.blog.service.UserRepository;
import com.example.blog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable("id") int id) {
        Optional<User> user = repository.findById(id);
//        User user = repository.getOne(id);
        if (!user.isPresent()) {
//        if (user == null) {
            throw new UserNotFoundException("id : " + id);
        }

        Resource<User> resource = new Resource<User>(user.get());
//        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

    @PutMapping("/users/{id}")
    public User modifyUser(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        User modifiedUser = repository.save(user);

        if (modifiedUser == null) {
            throw new UserNotFoundException("id : " + id);
        }
        return modifiedUser;
    }

}
