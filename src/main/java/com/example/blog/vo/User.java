package com.example.blog.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class User {
    private Integer id;
    @Size(min=2, message="이름은 2글자 이상 입력해주세요.")
    private String name;
    @Email(message = "Email 양식으로 입력해주세요")
    private String email;
    private Date joinDate;

    public User(Integer id, String name, String email, Date joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, email=%s, joinDate=%s]", id, name, email, joinDate);
    }
}
