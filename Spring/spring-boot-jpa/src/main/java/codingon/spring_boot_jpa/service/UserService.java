package codingon.spring_boot_jpa.service;

import codingon.spring_boot_jpa.dto.UserDTO;
import codingon.spring_boot_jpa.entity.User;
import codingon.spring_boot_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    모든 사용자의 정보를 반환
    public List<UserDTO> getAllUsers() {
//        1. Repository 게층에서 모든 User 리스트 가져옴
        List<User> users = userRepository.findAll();

//        2. 새로운 DTO 객체 리스트 생성
        List<UserDTO> userDTOs = new ArrayList<>();

//        3. 반복문을 이용해 User 객체를 UserDTO 객체로 변환하고, 리스트에 추가
        for (User user: users) {
            UserDTO userDTO = convertToDTO(user);
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

//    entity(domain) to dto
    private UserDTO convertToDTO(User user) {
//        builder 패턴을 이용해 DTO 객체 생성
        return UserDTO.builder()
                .no((int) (user.getId() + 100))
                .email(user.getEmail())
                .username(user.getUsername())
                .id(user.getId())
                .build();
    }
}