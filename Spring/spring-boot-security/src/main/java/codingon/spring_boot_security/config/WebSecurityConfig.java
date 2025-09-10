package codingon.spring_boot_security.config;

import codingon.spring_boot_security.security.JwtAuthenticationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration  // 스프링컨테이너에게 해당 클래스가 Bean 정의를 포함한 설정 클래스임을 알림
@EnableWebSecurity  // Spring Security 활성화
@Slf4j
public class WebSecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(withDefaults())   // cors 기본으로 설정
                .csrf(CsrfConfigurer::disable)  // csrf(공격 종류 중 1. 크로스사이트 요청위조 공격)를 disable 설정
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))   // session 기반이 아니므로 무상태(STATELESS) 설정
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/api/auth/**")  // 요청 경로가 일치하는 애들한테는
                .permitAll()    // /, /api/auth/** 경로는 인증 안해도 되게 모두 허용하겠다.
                .anyRequest().authenticated()); // 그 이외의 모든 경로는 인증 해야됨

//        filter 등록: 매 요청마다 CorsFilter를 실행한 후에 -> JwtAuthenticationFilter를 실행되게 순서 세팅
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);

        return http.build();
    }

//    cors 설정
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

//        모든 출처, 메소드, 헤더에 대해 허용하는 cors 설정
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("HEAD", "POST", "GET", "DELETE", "PUT", "PATCH"));
        config.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}