package codingon.spring_boot_security.repository;

import codingon.spring_boot_security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    Boolean existsByEmail(String email);    // Boolean:: true, false, null / boolean: true, false
    UserEntity findByEmailAndPassword(String email, String password);
}