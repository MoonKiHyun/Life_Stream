package com.moon.lifestream.domain.member.dto;

public record MemberLoginRequest(
        String email, String password
) {
}
