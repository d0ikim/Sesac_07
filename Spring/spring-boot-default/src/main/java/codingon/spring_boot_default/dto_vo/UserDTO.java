package codingon.spring_boot_default.dto_vo;

// DTO
// -> 단순히 데이터를 전송하기 위한 목적으로 사용되니
//    getter, setter 정도만을 가짐 (비즈니스 로직 미포함)

import lombok.*;

//@Getter
//@Setter
//@ToString
@Data   // @Getter, @Setter, @ToString 등의 어노테이션 포함
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드를 갖는 생성자
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private int age;

////    기본 생성자
//    public UserDTO(){}
//
////    모든 필드를 갖는 생성자
//    public UserDTO(int age, String email, String username, Long id){
//        this.age = age;
//        this.email = email;
//        this.username = username;
//        this.id = id;
//    }

    // getter, setter
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public String getUsername() { return username; }
//    public void setUsername(String username) { this.username = username; }
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//    public int getAge() { return age; }
//    public void setAge(int age) { this.age = age; }

//    @Override
//    public String toString() {
//        return "UserDTO{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
