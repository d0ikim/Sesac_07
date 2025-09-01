package codingon.spring_boot_mybatis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// dto.UserDTO
// - 데이터 전송 객체(DTO)로 클라이언트와 서버 간의 데이터 교환에 사용
// - 클라이언트에게 노출하고 싶지 않은 정보를 domain.User 에만 포함하고, DTO 변환 과정에서는 제외할 수 있음
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
//    "no" 필드 : 실제 데이터베이스에 존재하는 컬럼은 아니지만 서비스 로직에서 no 정보를 활용할 예정이라 추가
    private int no;
}