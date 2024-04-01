package com.moon.lifestream.domain.member.service;

import com.moon.lifestream.domain.member.dto.MemberSignupRequest;

public interface MemberService {

    void signup(MemberSignupRequest signup);
}
