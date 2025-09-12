package codingon.spring_boot_security.controller;

import codingon.spring_boot_security.dto.ResponseDTO;
import codingon.spring_boot_security.dto.TodoDTO;
import codingon.spring_boot_security.entity.TodoEntity;
import codingon.spring_boot_security.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

//    1. Create
    @PostMapping
    public ResponseEntity<?> createTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto) {
//        <?> : 유연한 Generic 타입을 쓰겠다는 의미
//        @AuthenticationPrincipal
//        - 현재 인증된 사용자 정보에 접근할 수 있게 됨
//        - Spring Security는 security context에서 현재 인증된 사용자의 principal을 가져옴
//        우리 코드에서는) jwtAuthenticationFilter클래스에서 userId를 바탕으로 인증객체 생성
        try {
//            todo: 임시 유저 하드코딩한 부분으로 추후 로그인된 유저로 변경 필요
//            String temporaryUserId = "temporary-user";

//            (1) DTO to Entity
            TodoEntity entity = TodoDTO.toEntity(dto);

//            (2) 생성하는 당시에는 id(pk)는 null로 초기화
//            - 새로 생성하는 레코드(행)이기 때문
            entity.setId(null); // 어차피 DB단(TodoEntity.java - @Id @GeneratedValue() )에서 자동발급해줄거니까!

//            (3) 유저 아이디 설정 ("누가" 생성한 투두인지를 설정)
//            entity.setUserId(temporaryUserId);    // 임시 유저 하드코딩한 부분으로 추후 로그인된 유저로 변경함
//            기존 temporaryUserId 대신 매개변수로 넘어온 userId 설정
            entity.setUserId(userId);

//            (4) 서비스 계층을 이용해 TodoEntity 생성
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

//    2. Read
    @GetMapping
    public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId){
//        TODO: 임시 유저 하드코딩한 부분으로 추후 로그인된 유저로 변경 필요
//        String temporaryUserId = "temporary-user";

//        (1) 서비스 게층의 retrieve 메서드를 사용해 투두리스트 가져오기
//        List<TodoEntity> entities = service.retrieve(temporaryUserId);    // 임시 유저 하드코딩한 부분으로 추후 로그인된 유저로 변경함
        List<TodoEntity> entities = service.retrieve(userId);

//        (2) 리턴된 엔티티리스트를 TodoDTO리스트로 변환
        List<TodoDTO> dtos = new ArrayList<>();
        for (TodoEntity tEntity: entities) {
            TodoDTO tDto = new TodoDTO(tEntity);    // TodoEntity -> TodoDTO로 변환하는 생성자
            dtos.add(tDto);
        }

//        (3) 변환된 TodoDTO리스트를 이용해 ResponseDTO를 초기화
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

//        (4) ResponseDTO를 클라이언트에게로 리턴
        return ResponseEntity.ok().body(response);  // 응답 body를 response(TodoDTO)인스턴스로 설정
    }

//    3. Update
    @PutMapping
    @RequestMapping("/{id}")
    public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId, @PathVariable Long id, @RequestBody TodoDTO dto) {
//        (1) DTO to Entity
        TodoEntity entity = TodoDTO.toEntity(dto);  // 요청body로 받은 dto(필요한 필드만 전달하는 객체)를 Entity(DB형식)인스턴스로 변환해 저장

//        (2) 수정할 entity의 id(pk)초기화
        entity.setId(id);   // 새로 만든 Entity인스턴스에 경로변수로 받은 투두id값 설정

//        (3) 유저 아이디 설정 ("누가" 생성한 투두를 수정할지 설정)
        entity.setUserId(userId);   // 새로 만든 Entity인스턴스에 매개변수로 받은 userId값 설정

//        (4) 서비스 계층을 이용해 TodoEntity 수정
//        서비스계층에 만든 update 메소드 호출해,
        List<TodoEntity> entities = service.update(entity); // 수정한 그 행을 포함한, 해당 유저의 투두들 전체 반환된 값 엔티티(DB형식)리스트 만들어 저장

//        (5) 리턴된 엔티티(DB형식)리스트 속 투두들을 TodoDTO(필요한필드만 전달하는 객체 - 보안.캡슐화과정?)로 변환
        List<TodoDTO> dtos = new ArrayList<>(); // 배열리스트로 프론트에 보낼 필드만 들어있는 DTO들리스트를 만듬
        for (TodoEntity tEntity: entities) {    // 반환된 엔티티(DB형식)리스트들 순회하며,
            TodoDTO tDto = new TodoDTO(tEntity);    // t(odo)Entity를 t(odo)DTO로 변환하는 생성자
            dtos.add(tDto);
        }

//        응답DTO 만들기
        ResponseDTO<TodoDTO> response = ResponseDTO
                .<TodoDTO>builder()
                .data(dtos)
                .build();

        return ResponseEntity.ok().body(response);
    }

//    4. Delete
//    @DeleteMapping
//    @RequestMapping("/{id}")
//    public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId, @PathVariable Long id) {
////        (1) 서비스 계층의 retrieve 메서드를 사용해 해당 user의 투두들 가져오기
//        List<TodoEntity> entities = service.retrieve(userId);
//
////        (2) 서비스 계층의 delete 메서드를 사용해 투두 삭제하기
//        service.delete(id);
//    }
}