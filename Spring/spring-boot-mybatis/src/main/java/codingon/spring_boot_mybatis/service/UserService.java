package codingon.spring_boot_mybatis.service;

import codingon.spring_boot_mybatis.domain.User;
import codingon.spring_boot_mybatis.dto.UserDTO;
import codingon.spring_boot_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service    // 이 클래스가 서비스 계층의 컴포넌트임을 나타냄
public class UserService {
//    UserService 가 UserMapper 를 사용하기에 UserMapper 인터페이스의 구현체를 자동 주입받음
    @Autowired  // 자동주입 받는 어노테이션
    private UserMapper userMapper;
    
//    모든 사용자의 정보(DB로 부터 읽어온 domain.User 리스트)를 UserDTO 로 반환
    public List<UserDTO> getAllUsers() {
//        1) 모든 domain.User 객체 가져옴
        List<User> users = userMapper.findAll();

//        2) 새로운 DTO 객체 생성
        List<UserDTO> userDTOs = new ArrayList<>();

//        3) 반복문을 이용해 각 user 객체를 userDTO로 변환하고 리스트에 추가
        for (User user: users) {
            UserDTO userDTO = convertToDto(user);
            userDTOs.add(userDTO);
        }
//        4) UserDTO 리스트 반환
        return userDTOs;
    }

//    특정 ID의 사용자 정보를 UserDTO로 변환
    public UserDTO getUserById(Long id) {
        User user = userMapper.findById(id);

        return convertToDto(user);
    }

//    새 사용자 생성
    public void createUser(UserDTO userDTO) {
//        userMapper.insert(userDTO) 불가해서
        User user = convertToEntity(userDTO);   // dto -> domain
        userMapper.insert(user);    // domain을 기반으로 mapper한테 insert 요청
    }

//    사용자 정보 업데이트
    public void updateUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);   // dto -> domain
        userMapper.update(user);    // domain을 기반으로 mapper한테 update 요청
    }

//    domain to dto
    private UserDTO convertToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setNo((int) (user.getId() + 100));

        return dto;
    }

//    dto to domain
    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        return user;
    }
    
//    참고. domain.User 와 dto.UserDTO 를 서로 변환하는 이유
//    - domain.User : 데이터베이스 엔티티를 표현
//    - dto.UserDTO : 클라이언트와 데이터 전송에 사용
//    DTO를 사용하게 되면 클라이언트의 요구사항에 맞춰서 데이터 구조를 쉽게 변경
//    -> 필요한 데이터만 클라이언트에 전송해서 네트워크 부하도 줄일 수 있다
//    -> API 버전 관리 용이 (엔티티(도메인) 변경 시 DTO를 통해 이전 버전과의 호환성 유지 가능)
}