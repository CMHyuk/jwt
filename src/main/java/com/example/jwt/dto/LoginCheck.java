package com.example.jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginCheck {

    private final Long id;

    public LoginCheck(Long id) {
        this.id = id;
    }
}
