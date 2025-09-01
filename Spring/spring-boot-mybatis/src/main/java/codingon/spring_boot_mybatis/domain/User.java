package codingon.spring_boot_mybatis.domain;

import lombok.Getter;
import lombok.Setter;

// domain.User 클래스
// - 데이터베이스 엔티티(객체)를 표현하는 도메인
// - 실제 데이터의 역할이므로 "테이블 구조"와 동일해야 함
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String email;
    private String createdAt;
}
