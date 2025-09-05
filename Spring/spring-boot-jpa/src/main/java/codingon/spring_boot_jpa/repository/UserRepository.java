package codingon.spring_boot_jpa.repository;

import codingon.spring_boot_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    기본적인 CRUD 작업을 위한 메서드들을 제공 받음
//    ㄴ findAll(), findById(), save(), deleteById() 등
//    첫번째 제네릭 타입은 관련 테이블, 두번째 제네릭 타입은 관련 테이블 PK의 타입


}
