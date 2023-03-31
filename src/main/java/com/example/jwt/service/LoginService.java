package com.example.jwt.service;

import com.example.jwt.config.AppConfig;
import com.example.jwt.dto.JwtResponse;
import com.example.jwt.dto.LoginRequest;
import com.example.jwt.entity.Member;
import com.example.jwt.repository.MemberRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    private final AppConfig appConfig;

    public JwtResponse login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .filter(m -> m.getPassword().equals(request.getPassword()))
                .orElseThrow(IllegalArgumentException::new);

        SecretKey key = Keys.hmacShaKeyFor(appConfig.getJwtKey());

        String jws = Jwts.builder()
                .setSubject(String.valueOf(member.getId()))
                .signWith(key)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+60*10000)) //토큰 유효시간 10초
                .compact();

        return new JwtResponse(jws);
    }
}
