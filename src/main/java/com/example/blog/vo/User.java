package com.example.blog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private Date joinDate;

    public User(Integer id, String name, Date joinDate) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, joinDate=%s]", id, name, joinDate);
    }
}
