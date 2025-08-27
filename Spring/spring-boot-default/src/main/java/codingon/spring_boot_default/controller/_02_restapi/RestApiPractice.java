package codingon.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestApiPractice {
    @GetMapping("/introduce/{name}")
//    /introduce/홍길동 으로 접속 시
    @ResponseBody
    public String getIntroduce(@PathVariable String name) {
        return "내 이름은 " + name;
    }

    @GetMapping("/introduce2")
//    /introduce2?name=홍길동&age=10 으로 접속 시 (query string => @RequestParam)
    @ResponseBody
    public String getIntroduce2(@RequestParam String name, @RequestParam int age) {
        return "내 이름은 " + name +"<br>내 나이는 " + age;
    }

    /// //////////// POST /////////////////////////////////////
    @PostMapping("/introduce")
    @ResponseBody
    public String postIntroduce(@RequestParam String name, @RequestParam String gender, @RequestParam String birth, @RequestParam List<String> interest) {
        return "이름 : "+name+"<br>성별 : "+gender+"<br>생년월일 : "+birth+"<br>관심사 : "+String.join(",",interest);
    }
}
