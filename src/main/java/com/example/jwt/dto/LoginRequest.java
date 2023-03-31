package com.example.jwt.dto;

import lombok.Getter;

@Getter
public class LoginRequest {

    private String email;
    private String password;
}
