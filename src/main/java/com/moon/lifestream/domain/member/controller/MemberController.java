package com.moon.lifestream.domain.member.controller;

import com.moon.lifestream.domain.member.dto.MemberSignupRequest;
import com.moon.lifestream.domain.member.service.MemberService;
import com.moon.lifestream.global.response.ApiResponse;
import io.jsonwebtoken.lang.Strings;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Void>> signup(@RequestBody @Valid MemberSignupRequest request) {

        memberService.signup(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(HttpStatus.CREATED.value(), "Sign up completed"));
    }

    public static void main(String[] args) {

        List<String> stringsA = new LinkedList<>();
        List<String> stringsB = new ArrayList<>();

        for (int i = 0; i < 10000; i ++) {
            stringsA.add(String.valueOf(i));
            stringsB.add(String.valueOf(i));
        }

        long startTime;
        long endTime;

        // LinkedList 시간
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i ++) {
            stringsA.add(0, String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.printf("%-17s  %8d ms \n", "LinkedList 걸린 시간", (endTime - startTime));

        // ArrayList 시간
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i ++) {
            stringsB.add(0, String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.printf("%-17s  %8d ms \n", "ArrayList 걸린 시간", (endTime - startTime));
    }
}
