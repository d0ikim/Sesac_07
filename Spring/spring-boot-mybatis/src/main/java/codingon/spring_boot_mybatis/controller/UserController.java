package codingon.spring_boot_mybatis.controller;

import codingon.spring_boot_mybatis.dto.UserDTO;
import codingon.spring_boot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RESTful 웹 서비스의 컨트롤러
// - 해당 클래스 "모든 메서드"의 반환 값이 자동으로 JSON 형식으로 변환되어 HTTP 응답 본문에 포함
// - @Controller + @ResponseBody 를 결합한 어노테이션
@RequestMapping("/api/users") // 해당 클래스의 기본 요청 경로를 지정
public class UserController {
//    Controller 게층은 Service 게층을 사용 -> 의존
    @Autowired
    private UserService userService;

//    모든 사용자 정보를 리스트로 반환
    @GetMapping
    public List<UserDTO> listUsers() {
        return userService.getAllUsers();
    }

//    POST /api/users : 새 사용자를 생성하고 생성된 사용자 정보 반환
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
//        @RequestBody : HTTP 요청 본문을 자바 객체로 변환
        userService.createUser(userDTO);
        return userDTO;
    }

//    GET /api/users/:id : 특정 ID의 사용자 정보를 반환
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}