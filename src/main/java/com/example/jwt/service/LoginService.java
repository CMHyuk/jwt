package com.example.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginResponse login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .filter(m -> m.getPassword().equals(request.getPassword()))
                .orElseThrow(IllegalArgumentException::new);

        return LoginResponse.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
