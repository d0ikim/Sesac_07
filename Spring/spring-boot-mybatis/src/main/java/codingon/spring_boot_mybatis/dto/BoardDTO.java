package codingon.spring_boot_mybatis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// dto.BoardDTO
// - 클라이언트에게 노출하고 싶지 않은 정보를 domain.Board 에만 포함하고, DTO 변환 과정에서는 제외할 수 있음
@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String registered;
}
