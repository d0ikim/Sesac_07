package codingon.spring_boot_security.service;

import codingon.spring_boot_security.entity.UserEntity;
import codingon.spring_boot_security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

//    인증 : 이메일과 비밀번호로 사용자 조회
    public UserEntity getByCredentials(final String email, final String password) {
//        DB에서 해당 email, password가 일치하는 유저가 있는지를 조회
        return repository.findByEmailAndPassword(email, password);
    }
}