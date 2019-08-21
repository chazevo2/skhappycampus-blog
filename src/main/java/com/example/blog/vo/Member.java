package com.example.blog.vo;

import lombok.Data;

@Data
public class Member {
    private int id;
    private String name;
    private String email;

    public Member() {
    }

    public Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
