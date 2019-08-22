package com.example.blog.controller;

import com.example.blog.vo.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello, World!");
    }

    @GetMapping(value = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable("name") String name) {
        return new HelloWorldBean(String.format("Hello, %s!", name));
    }

    @GetMapping(value = "/hello-world/internationalized")
    public String helloWorldInternationalized() {
        String msg = messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
        return msg;
    }
}
