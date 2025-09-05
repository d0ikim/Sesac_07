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
    
//    특정 id의 사용자 정보를 반환
    public UserDTO getUserById(Long id) {
//        JPA가 기본 제공하는 findById()로 특정 유저를 찾을 텐데
//        있다면 User객체로 반환, 찾지 못하면 null 반환
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return convertToDTO(user);
    }

//    새 사용자 생성
    public void createUser(UserDTO userDTO) {
//        1. 클라이언트한테 추가해야할 정보를 받음
        User user = convertToEntity(userDTO);

//        2. repository 에게 추가 요청
        userRepository.save(user);
    }

//    특정 id의 사용자 정보를 수정
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = convertToEntityWithId(id, userDTO);
        userRepository.save(user);
        return convertToDTO(user);
    }

//    특정 id의 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /// ////////////////////////////////////////////////
    public List<UserDTO> getUserByUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user:users) {
            userDTOs.add(convertToDTO(user));
        }
        return userDTOs;
    }

    public List<UserDTO> searchUsers(String keyword) {
//        List<User> users = userRepository.findByUsernameContainingOrEmailContaining(keyword, keyword);
        List<User> users = userRepository.findByUsernameContainingOrEmailContaining(keyword);

//        - 첫 번째 인자: username 을 검색하기 위한 keyword 매개값
//        - 두 번째 인자: email 을 검색하기 위한 keyword 매개값
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user:users) {
            userDTOs.add(convertToDTO(user));
        }

        return userDTOs;
    }

    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
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

//    dto to entity(domain)
    private User convertToEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
    }

//    dto to entity with id
    private User convertToEntityWithId(Long id, UserDTO dto) {
        return User.builder()
                .id(id)
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
    }
}