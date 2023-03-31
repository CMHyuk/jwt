package com.example.jwt.controller;

import com.example.jwt.dto.LoginCheck;
import com.example.jwt.config.Login;
import com.example.jwt.dto.JwtResponse;
import com.example.jwt.dto.LoginRequest;
import com.example.jwt.dto.MemberSaveRequest;
import com.example.jwt.service.LoginService;
import com.example.jwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final LoginService loginService;

    @PostMapping("/save")
    public Long save(@RequestBody MemberSaveRequest request) {
        return memberService.save(request);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

    @GetMapping("/auth")
    public Long auth(@Login LoginCheck loginCheck) {
        return loginCheck.getId();
    }
}
