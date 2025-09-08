package codingon.spring_boot_security.controller;

import codingon.spring_boot_security.dto.ResponseDTO;
import codingon.spring_boot_security.dto.TodoDTO;
import codingon.spring_boot_security.entity.TodoEntity;
import codingon.spring_boot_security.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService service;

//    ResponseEntity 란?
//    - 해당 객체를 이용해 상태코드, 응답 본문 등을 설정해서 클라이언트 응담
//    - HTTP 응답의 상태코드와 헤더를 포함해 더 세부적으로 제어가 가능
//    메서드
//    - ok(): 요청 성공 시
//    - headers(): 응답 헤더 부가적으로 설정하고 싶을 시
//    - body(): 응답 본문 설정
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto) {
//        <?> : 유연한 Generic 타입을 쓰겠다는 의미
        try {
//            TODO: 임시 유저 하드코딩한 부분으로 추후 로그인된 유저로 변경 필요
            String temporaryUserId = "temporary-user";

//            (1) DTO to Entity
            TodoEntity entity = TodoDTO.toEntity(dto);

//            (2) 생성하는 당시에는 id(pk)는 null로 초기화
//            - 새로 생성하는 레코드(행)이기 때문
            entity.setId(null); // 어차피 DB단(TodoEntity.java - @Id @GeneratedValue() )에서 자동발급해줄거니까!

//            (3) 유저 아이디 설정 ("누가" 생성한 투두인지를 설정)
//            TODO: 임시 유저 하드코딩한 부분으로 추후 로그인된 유저로 변경 필요
            entity.setUserId(temporaryUserId);

//            (4) 서비스 게층을 이용해 TodoEntity 생성
            List<TodoEntity> entities = service.create(entity);

//            (5) 리턴된 엔티티리스트를 TodoDTO로 변환
            List<TodoDTO> dtos = new ArrayList<>();
            for (TodoEntity tEntity: entities) {    // (4)의 for문
                TodoDTO tDto = new TodoDTO(tEntity);    // TodoEntity -> TodoDTO로 변환하는 생성자
                dtos.add(tDto);
            }

//            (6) 변환된 todoDTO리스트를 이용해 ResponseDTO 초기화
//            -> TodoDTO타입을 담는 ResponseDTO 객체를 빌드하겠습니다..!
            ResponseDTO<TodoDTO> response = ResponseDTO // 응답DTO<TodoDTO> 응답객체변수명 = 응답DTO
                    .<TodoDTO>builder() // .<지금너가만들어야될 T는 TodoDTO야 라는 힌트>builder()
                    .data(dtos) // .data(로 setSomething() 대신, 한꺼번에 데이터 넣을수있음)
                    .build();   // .build();

//            (7) ResponseDTO를 클라이언트에게 응답
//            ResponseEntity.ok(): HTTP 상태코드를 200으로 설정
//            body(response): 응답의 body를 response인스턴스로 설정
            return ResponseEntity.ok().body(response);  
        } catch (Exception e) {
//            (8) 예외가 발생한 경우, ResponseDTO의 data필드 대신, error필드에 에러메시지를 넣어서 리턴
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();

//            badRequest(): 400 에러 응답을 전송
            return ResponseEntity.badRequest().body(response);
        }
    }
}