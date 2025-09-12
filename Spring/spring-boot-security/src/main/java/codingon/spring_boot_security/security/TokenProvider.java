package codingon.spring_boot_security.security;

import codingon.spring_boot_security.config.jwt.JwtProperties;
import codingon.spring_boot_security.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

// 사용자 정보를 받아 JWT 생성하는 클래스
@Service    // 서비스게층 컴포넌트로 등록해서 다른 곳에서 주입받아서 쓰기 위함
@Slf4j
public class TokenProvider {
//    [before] JWT 서명에 사용되는 비밀키 (일단은 하드코딩, TODOd 나중에 하위 [after]로 바꾸었음)
//    private static final String SECRET_KEY = "sesac-spring-boot-kimdoi1004";

//    [after] JwtProperties 클래스 이용해 설정 파일 값 불러오기
    @Autowired
    private JwtProperties jwtProperties;

//    create(): JWT 생성
//    => 로그인 성공 시에 이 메서드가 호출되어 JWT 토큰을 발급함
    public String create(UserEntity userEntity) {
//        JST 토큰 만료 시간을 현재시각으로부터 1일뒤 만료되는 날짜로 계산
        Date expiryDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));

//        JWT 토큰 생성
        return Jwts.builder()
//                jwt header(암호화 알고리즘, 타입) 에 들어갈 내용 및 서명하기 위한 SECRET KEY
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
//                jwt payload(sub,name,admin,iat 등)
                .setSubject(String.valueOf(userEntity.getId())) // sub: 토큰 제목(여기서는 userId)
                .setIssuer("demo app")                          // iss: 토큰 발급자
                .setIssuedAt(new Date())                        // iat: 토큰이 발급된 시간
                .setExpiration(expiryDate)                      // exp: 토큰 만료 시간
                .compact();                                     // 토큰 생성해주세요! -> "header.payload.signature" 토큰 문자열 최종 생성(리턴타입 그래서 String)
    }

//    validateAndGetUserId(): 토큰 디코딩 및 파싱하고, 토큰 위조 여부를 확인 -> 사용자의 id 리턴
//    => 클라이언트가 보낸 토큰이 유효한지 검증하고, userId를 반환함
    public String validateAndGetUserId(String token) {
//        parseClaimsJws메소드가 Base64로 디코딩 및 파싱
//        - header, payload를 setSigningKey로 넘어온 SECRET KEY를 사용해 서명한 후, token의 서명이랑 비교
//        - 서명이 위조되거나 만료된 토큰이라면 예외 발생
//        - 위조되지 않았다면 페이로드(Claims) 리턴
        Claims claims = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())  // 서명 검증에 사용할 비밀키 지정
                .parseClaimsJws(token)      // JWT 파싱 -> header, payload, signature 검증
                .getBody();

        return claims.getSubject(); // 32번줄 jwt 생성시 넣었던 sub(userId) 값을 꺼냄
    }
}