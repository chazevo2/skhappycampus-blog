package com.example.blog.controller;

import com.example.blog.vo.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BlogController {
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello, Junhyuk.";
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public Member getInfo() {
        Member member = new Member(1, "Junhyuk, Park", "chazevo2@gmail.com");
        return member;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Member> list() {
        List<Member> memberList = Arrays.asList(new Member[]{
                new Member(1, "Junhyuk1, Park", "chazevo2@gmail.com"),
                new Member(2, "Junhyuk2, Park", "chazevo2@gmail.com"),
                new Member(3, "Junhyuk3, Park", "chazevo2@gmail.com"),
                new Member(4, "Junhyuk4, Park", "chazevo2@gmail.com"),
                new Member(5, "Junhyuk5, Park", "chazevo2@gmail.com")
        });

        // test
        long startTime = System.currentTimeMillis();
        for (Member member : memberList) {
            System.out.println(member);
        }
        System.out.println("for-loop : " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        memberList.forEach(System.out::println);
        System.out.println("lambda : " + (System.currentTimeMillis() - startTime) + "ms");
        // test

        return memberList;
    }
}
