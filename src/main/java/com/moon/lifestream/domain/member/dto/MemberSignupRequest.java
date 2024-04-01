package com.moon.lifestream.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record MemberSignupRequest(
        @Email(message = "올바른 이메일을 입력해 주세요.") String email,
        @Pattern(regexp = "^[a-zA-Z가-힣0-9]{3,20}$", message = "3~20자의 영문 대/소문자, 한글, 숫자를 사용해 주세요.") String username,
        @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*_?~]{8,40}", message = "영문 대/소문자, 숫자, 특수문자(!@#$%^&*_?~) 중 3종류 이상으로 구성하여 8~40자의 비밀번호를 사용해 주세요.") String password
) {
}
