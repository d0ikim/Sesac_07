package codingon.spring_boot_default.controller._02_restapi;

import codingon.spring_boot_default.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestApiPractice_02 {
    @GetMapping("/signup")
    public String axiosGetSignup() {
        return "_02_restapi/restApiPractice_02";
    }

    @PostMapping("/signup")
    @ResponseBody
    public String axiosPostSignup(@RequestBody UserVO userVO) {
        return userVO.getName() + " 회원가입 성공";
    }
}