package codingon.spring_boot_security.controller;

import codingon.spring_boot_security.dto.ResponseDTO;
import codingon.spring_boot_security.dto.UserDTO;
import codingon.spring_boot_security.entity.UserEntity;
import codingon.spring_boot_security.security.TokenProvider;
import codingon.spring_boot_security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  // 로깅
@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

//    [after] JWT 적용
    @Autowired
    private TokenProvider tokenProvider;

//    [after] 패스워드 암호화
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
//            요청 본문을 이용해 저장할 사용자 만들기
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(passwordEncoder.encode(userDTO.getPassword()))    // 패스워드 암호화 추가
                    .build();

//            서비스계층 메서드를 이용해 repo에 사용자 자저아
            UserEntity registeredUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(registeredUser.getEmail())
                    .id(registeredUser.getId())
                    .username(registeredUser.getUsername())
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);
        } catch(Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
    
//    로그인
    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        UserEntity user = userService.getByCredentials( // 사용자 인증하는 메서드
                userDTO.getEmail(), userDTO.getPassword(), passwordEncoder  // BCrypt패스워드인코더 추가
        );

        if (user != null) {
//            로그인 검사 통과!

            /*
            [before]
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(userDTO.getId())
                    .build();
             */

//            [after] JWT 적용 후
            final String token = tokenProvider.create(user);
//            System.out.println("token="+token);
//            System.out.println("user="+user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(userDTO.getId())
                    .token(token)   // 토큰 설정
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);
        } else {
//            로그인 검사 실패! (해당 유저가 존재하지 않았으므로)
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login failed.")
                    .build();

            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}