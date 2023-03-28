package com.example.jwt;

import lombok.Getter;

@Getter
public class MemberSaveRequest {

    private String email;
    private String password;
}
