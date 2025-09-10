package codingon.spring_boot_security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j  // 로깅 라이브러리
@Component  // 스프링 컨테이너한테 Bean으로 등록해서 의존성 주입받으려고
public class JwtAuthenticationFilter extends OncePerRequestFilter { // Servlet Filter를 구현한것
//    OncePerRequestFilter클래스를 상속받는 JwtAuthenticationFilter 구현
//    - OncePerRequestFilter 클래스: 한 요청당 반드시 한 번만 실행됨
    @Autowired
    private TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest req, HttpServletResponse res,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
//            req 에서 token 꺼내오기
            String token = parseBearerToken(req);
            log.info("JwtAuthenticationFilter is running...");

//            token 검사
            if (token != null && !token.equalsIgnoreCase("null")) {
                String userId = tokenProvider.validateAndGetUserId(token);
                log.info("Authenticated user id: "+userId);

//                직전에 추출한 userId로 인증 객체 생성
                AbstractAuthenticationToken authentication
                        = new UsernamePasswordAuthenticationToken(  // username이랑 password로 인증토큰객체 만드는 spring security 메소드
                                userId, null, AuthorityUtils.NO_AUTHORITIES);   // 권한목록.없음 설정
                authentication.setDetails((new WebAuthenticationDetailsSource().buildDetails(req)));

//                SecurityContextHolder: Spring Security에서 인증된 사용자 정보를 저장하는 곳
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                securityContext.setAuthentication(authentication);  // 컨텍스트에 authentication으로 심으면 이후부터는 인증된 사용자로 인식됨
                SecurityContextHolder.setContext(securityContext);
            }
        } catch(Exception e) {
//            logger? spring security 필터 클래스에 기본 내장된 로그
            logger.error("Could not set user authentication is security context", e);   // OncePerRequestFilter에서 가지고오는 객체
        }

//        다음 필터/컨트롤러로 넘김
        filterChain.doFilter(req, res);
    }

//    요청의 헤더에서 Bearer 토큰을 가져옴
//    http요청의 헤더를 파싱해서 Bearer 토큰을 리턴
    private String parseBearerToken(HttpServletRequest req) {
//        헤더에 Authorization: Bearer <token> 이런식으로 들어있을거임 
        String bearerToken = req.getHeader("Authorization");    // Authorization이란 key값을 가진 문자열을 꺼냄

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {    // 조건식의 마지막 공백 추가 오타 아님!!
            return bearerToken.substring(7);    // "Bearer " 문자열의 길이가 7. 얘네를 뺀 뒤에 순수 토큰값만 리턴
        }

        return null;
    }
}