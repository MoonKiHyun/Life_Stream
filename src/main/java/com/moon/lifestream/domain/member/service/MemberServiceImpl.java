package com.moon.lifestream.domain.member.service;

import com.moon.lifestream.domain.member.dto.MemberSignupRequest;
import com.moon.lifestream.domain.member.entity.Member;
import com.moon.lifestream.domain.member.entity.MemberRoleEnum;
import com.moon.lifestream.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class MemberServiceImpl implements MemberService{

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public void signup(MemberSignupRequest request) {

        String email = request.email();
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("That email is taken");
        }

        String username = request.username();
        if (memberRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("That username is taken");
        }

        String password = passwordEncoder.encode(request.password());

        memberRepository.save(Member.of(email, username, password, MemberRoleEnum.USER));


    }
}
