package com.example.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberSaveRequest request) {
        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        Member save = memberRepository.save(member);

        return save.getId();
    }

}
