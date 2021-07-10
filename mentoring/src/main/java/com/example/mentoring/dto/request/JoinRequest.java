package com.example.mentoring.dto.request;

import com.example.mentoring.domain.enums.Sex;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class JoinRequest {
    private String name;
    private Integer age;
    private Sex sex;

    @Email
    private String email;
    private String password;
}
