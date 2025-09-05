package codingon.spring_boot_jpa.repository;

import codingon.spring_boot_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // 기본적인 CURD 작업을 위한 메서드들을 제공 받음
    // ㄴ findAll(), findById(), save(), deleteById() 등
    // 첫번째 제네릭 타입은 관련 테이블, 두번째 제네릭 타입은 관련 테이블 PK 의 타입

    /*
    // case1. repository 메서드 사용
    // 1. 사용자 이름으로 n 명 조회
    // => select * from user where username = ?
    List<User> findByUsername(String username);

    // 2. 검색어 보냈을 때 사용자 이름/이메일에 특정 문자열이 포함된 모든 사용자 찾기
    // => select * from user where username like %xx% or email like %xx%
    List<User> findByUsernameContainingOrEmailContaining(String name, String email);

    // 3. 이름이 존재하는지
    boolean existsByUsername(String username);
    */

    // case2. @Query 어노테이션 사용
    // - JpaRepository 인터페이스에 내장된 메소드만으로는 해결이 안되는 경우, (raw query 를 작성해야 함)
    // - 단, Jpa 는 테이블 명이 아니라 객체 위주로 돌아가니 객체(Entity) 이름을 사용해야 함
    // - nativeQuery 옵션
    // : 찐 SQL 문을 사용하는 거라 DBMS 에 종속적이게 됨 (ORM 특장점을 활용하기 어려움)
    // ex. @Query(nativeQuery=true, value="select * from users")

    // 1. 사용자 이름으로 n 명 조회
    @Query("SELECT u FROM User u WHERE u.username = :username")
    // - User: 테이블이 아닌 Entity 이름
    // - @Param: 해당 어노테이션을 이용해 파라미터 바인딩
    List<User> findByUsername(@Param("username") String username);

    // 2. 검색어 보냈을 때 사용자 이름/이메일에 특정 문자열이 포함된 모든 사용자 찾기
    @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword% OR u.email LIKE %:keyword%")
    List<User> findByUsernameContainingOrEmailContaining(@Param("keyword") String keyword);

    // 3. 이름이 존재하는지
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END " +
            "FROM User u " +
            "WHERE u.username = :username")
        // 참고. CASE WHEN (조건식) THEN (결과1) ELSE (결과2) END (SQL문) => CASE WHEN 구문
    boolean existsByUsername(String username);


}