package codingon.spring_boot_security.service;

import codingon.spring_boot_security.entity.UserEntity;
import codingon.spring_boot_security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j  // 로깅 찍는 어노테이션
public class UserService {
    @Autowired
    private UserRepository repository;
    
//    회원가입 (사용자 생성)
    public UserEntity create(final UserEntity userEntity) {
//        유효성 검사 1) userEntity 혹은 email이 null인 경우 예외 던짐
        if (userEntity == null || userEntity.getEmail() == null) {
            throw new RuntimeException("Invalid arguments");
        }
        final String email = userEntity.getEmail();

//        유효성 검사 2) 이메일이 이미 존재하는 경우 예외를 던짐 (email필드는 unique해야 하므로)
        if (repository.existsByEmail(email)) {
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }

        return repository.save(userEntity);    // UserEntity를 DB에 저장
    }

    /*
//    인증 : 이메일과 비밀번호로 사용자 조회
    public UserEntity getByCredentials(final String email, final String password) {
//        DB에서 해당 email, password가 일치하는 유저가 있는지를 조회
        return repository.findByEmailAndPassword(email, password);
    }*/
    
//    [after] 패스워드 암호화 적용 후
    public UserEntity getByCredentials(final String email,
                                       final String password,
                                       final PasswordEncoder encoder) { // BCrypt패스워드인코더 받아오기
        final UserEntity originalUser = repository.findByEmail(email);  // 이메일이 일치하는 유저 하나를 찾음
        
        if (originalUser != null && encoder.matches(password, originalUser.getPassword())) {
//            password: 클라이언트가 주장하는 현재 유저에 대한 비밀번호
//            originalUser.getPassword(): DB에 저장된 정답 비밀번호
//            이메일로 찾은 유저가 존재하고, 매개변수로받은 pw가 유저의 pw와 일치하면
            return originalUser;    // 찾은 유저 반환
        }
        
        return null;    // 없다면 로그인 실패니까, null 반환
    }
}