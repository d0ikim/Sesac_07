package codingon.spring_boot_default.dto_vo;

public class UserExample {
    public static void main(String[] args) {
        UserDTO u1 = new UserDTO();
        u1.setId(1L);
        u1.setUsername("John");
        u1.setEmail("john@example.com");
        u1.setAge(30);
        System.out.println("u1 = "+u1);

//        UserDTO 객체 생성 (모든 필드를 갖는 생성자 사용)
        UserDTO  u2 = new UserDTO(2L, "Jane", "Jane@example.com", 40);

//        getter 를 이용해 특정 정보 접근
        System.out.println(u2.getUsername());
        System.out.println(u2.getEmail());

//        setter 를 이용해 정보 수정
        u2.setAge(21);
        System.out.println("u2 = "+u2);
    }
}
