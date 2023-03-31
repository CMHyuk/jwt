package com.example.jwt.dto;

import lombok.Getter;

@Getter
public class MemberSaveRequest {

    private String email;
    private String password;
}
