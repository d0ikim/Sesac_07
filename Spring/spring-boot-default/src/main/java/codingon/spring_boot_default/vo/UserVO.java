package codingon.spring_boot_default.vo;

import lombok.Getter;
import java.util.List;

@Getter
public class UserVO {
    private String name;
    private int age;
    private String birth;   // yyyy-mm-dd
    private List<String> interests; // 관심사
    private String gender;  // 여자
}