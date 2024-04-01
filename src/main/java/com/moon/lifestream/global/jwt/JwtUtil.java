package com.moon.lifestream.global.jwt;

import com.moon.lifestream.domain.member.entity.MemberRoleEnum;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_KEY = "auth";
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String CATEGORY = "category";
    public static final String CATEGORY_ACCESS = "access";
    public static final String CATEGORY_REFRESH = "refresh";
    public static final long ACCESS_TOKEN_TIME = 10 * 60 * 1000L;
    public static final long REFRESH_TOKEN_TIME = 24 * 60 * 60 * 1000L;

    @Value("${jwt.secret.key}")
    private String secretKeyString;
    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKeyString.getBytes(StandardCharsets.UTF_8));
        secretKey = new SecretKeySpec(bytes, Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public String createAccessToken(String username, MemberRoleEnum role) {

        return Jwts.builder()
                .subject(username)
                .claim(AUTHORIZATION_KEY, role)
                .claim(CATEGORY, CATEGORY_ACCESS)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_TIME))
                .signWith(secretKey)
                .compact();
    }

    public String createRefreshToken(String username, MemberRoleEnum role) {

        return Jwts.builder()
                .subject(username)
                .claim(AUTHORIZATION_KEY, role)
                .claim(CATEGORY, CATEGORY_REFRESH)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_TIME))
                .signWith(secretKey)
                .compact();
    }

    public String getAccessJwtFromHeader(HttpServletRequest request) {

        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {

            return bearerToken.substring(7);
        }

        return null;
    }

    public String getUsernameFromJwt(String token) {

        System.out.println("Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject() = " + Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject());

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public String getCategoryFromJwt(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get(JwtUtil.CATEGORY, String.class);
    }

    public Boolean isExpired(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }

}
