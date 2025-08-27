package codingon.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    // GET localhost:PORT/ 요청 시; _02_restapi/req.html 파일을 브라우저에 렌더링
    @GetMapping("/")
    public String getReq() { return "_02_restapi/req"; }

}