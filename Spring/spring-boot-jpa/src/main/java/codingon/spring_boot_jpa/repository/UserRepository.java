package codingon.spring_boot_jpa.repository;

import codingon.spring_boot_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    기본적인 CRUD 작업을 위한 메서드들을 제공 받음
//    ㄴ findAll(), findById(), save(), deleteById() 등
//    첫번째 제네릭 타입은 관련 테이블, 두번째 제네릭 타입은 관련 테이블 PK의 타입

    /*
//    case1. repository 메서드 사용
//    1. 사용자 이름으로 n명 조회
//    => select * from user where username = ?
    List<User> findByUsername(String username);

//    2. 검색어 보냈을 때 사용자이름/이메일에 특정 문자열이 포함된 모든 사용자 찾기
//    => select * from user where username like %xx% or email like %xx%
    List<User> findByUsernameContainingOrEmailContaining(String name, String email);

//    3. 이름이 존재하는지
    boolean existsByUsername(String username);
    */
    
//    case2. @Query 어노테이션 사용
}
