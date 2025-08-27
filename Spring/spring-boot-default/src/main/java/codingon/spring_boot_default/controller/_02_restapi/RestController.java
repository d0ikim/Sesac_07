package codingon.spring_boot_default.controller._02_restapi;

import codingon.spring_boot_default.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestController {

    // GET localhost:PORT/ 요청 시; _02_restapi/req.html 파일을 브라우저에 렌더링
    @GetMapping("/")
    public String getReq() { return "_02_restapi/req"; }

//    GET 요청

//    @RequestParam 어노테이션
//    - HTTP 요청 파라미터를 메서드 매개변수에 바인딩
//    - query string중에서 name key에 대한 value를 String name에 매핑
//    - required=true 가 기본값(생략됨)이므로 요청 URL에서 name key, age key를 필수로 보내야 함
//    - 퀴즈) age키 값을 보내지 않으면 에러가 발생하지만, name키 값은 보내지 않아도 잘 동작함? 왜 에러가 발생하지 않을까?
//        => int는 primitive type이지만, String은 빈 문자열도 유효한 값으로 취급되기떄문

//    #1 : http://localhost:8080/get/res1?name=김도이&age=27
    @GetMapping("get/res1")
    public String getRes1(@RequestParam(value = "name") String name,
                          @RequestParam(value = "age") int age,
                          Model model) {
        System.out.println("name = "+name); // name = 김도이
        System.out.println("age = "+age);   // age = 27

//        view에 전달할 데이터를 Model 객체에 추가
//        return될 res.html 에 전송될 속성 name과 age에 값 전달
        model.addAttribute("name",name);
        model.addAttribute("age",age);

//        응답 결과를 보여줄 뷰(resources/templates/.html) 이름 반환
        return "_02_restapi/res";
    }

//    #2 : http://localhost:8080/get/res2?
    @GetMapping("/get/res2")
    public String getRes2(@RequestParam(value="name", required=false) String name,
                          Model model) {
        System.out.println("name = "+name); // 처음에 name = null 출력

        model.addAttribute("name",name);

        return "_02_restapi/res";
    }

//    @PathVariable 어노테이션
//    - URL path variable을 사용할 때 필요한 어노테이션
//    - 기본적으로 path variable은 값을 가져야 함 (즉, 값이 없으면 404 error)

//    참고. URL의 path variable과 해당 메서드의 매개변수명을 다르게 사용하고 싶다면?
//    ex. @Path variable(value="param2") int age

//    #3 : http://localhost:8080/get/res3/홍길동/20, /get/res3/홍길동(error)
    @GetMapping("/get/res3/{param1}/{param2}")
    public String getRes3(@PathVariable String param1,
                          @PathVariable(value="param2") int age,
                          Model model) {
        System.out.println("name = "+param1);   // 홍길동
        System.out.println("age = "+age);       // 20

        model.addAttribute("name",param1);
        model.addAttribute("age",age);

        return "_02_restapi/res";
    }

//    #4 : http://localhost:8080/get/res4/성춘향/21, /get/res4/성춘향
//    선택적으로 받아오는 path variable이 있으면, {} 안에 경로 여러개 설정
//    path variable 중에서 name은 필수경로변수, age는 선택경로변수 라면?
//    - required = false 옵션을 선택경로변수에서는 사용해야 하고,
//    - optional 한 변수가 맨 뒤에 와야함(선택경로변수가)

//    참고. 선택경로변수 age의 타입이 int가 아니라 Integer인 이유?
//    - age (정수형) optional한 값이므로 null이 가능
//    - primitive type (int) 은 null 값을 가질 수 없음
//    - 따라서, reference type인 객체를 사용하고자 Integer 선언 (null 값이 들어올 수 있도록)
    @GetMapping({"get/res4/{name}/{age}", "/get/res4/{name}"})
    public String getRes4(@PathVariable String name,    // default required=true로 name 경로변수 설정
                          @PathVariable(required = false) Integer age,   // 선택적으로 받는 경로변수(뒤에 와야함)
                          Model model) {
        System.out.println("name = "+name);
        System.out.println("age = "+age);

        model.addAttribute("name",name);
        model.addAttribute("age",age);
        
        return "_02_restapi/res";
    }


    /// /////////////////////////////// POST ///////////////////////////////////////
//    POST 요청
//    #5 (required=true) : /post/res1
    @PostMapping("post/res1")
    public String postRes1(@RequestParam String name,
                           @RequestParam int age,
                           Model model) {
        System.out.println("name = "+name);
        System.out.println("age = "+age);

        model.addAttribute("name",name);
        model.addAttribute("age",age);

        return "_02_restapi/res";
    }

//    #6 (required=false) : /post/res2
    @PostMapping("post/res2")
    public String postRes2(@RequestParam String name,
                           @RequestParam(required = false) Integer age,
                           Model model) {
        System.out.println("name = "+name);
        System.out.println("age = "+age);

        model.addAttribute("name",name);
        model.addAttribute("age",age);

        return "_02_restapi/res";
    }

//    #1~6 폼까지는 항상 Template View를 반환
//    하지만, Spring Boot를 API서버로 활용하고자 데이터자체를 응답하고 싶다면?
//    => @ResponseBody 어노테이션 사용

//    #7 : : /post/res3
    @PostMapping("/post/res3")
    @ResponseBody   // 메서드의 반환값을 응답 본문(response body)에 직접 쓰도록 지시
//    @ResponseBody 어노테이션
//    - 응답 시 객체를 JSON 등으로 리턴할 때 사용
//    - 즉, 응답 객체를 전달 (node express res.send() 와 유사)
    public String postRes2(@RequestParam String name,
                           @RequestParam int age,
                           Model model) {
        System.out.println("name = "+name);
        System.out.println("age = "+age);

        model.addAttribute("name",name);
        model.addAttribute("age",age);

//        템플릿 엔진(res.html)이 아닌 문자열 그 자체를 응답시킴
        return name + " " + age;    // 화면에 html이 아닌 문자열 [김도이 27] 만 뜸
    }


    /// ////////////////////////// DTO //////////////////////////////////////////
//    #8 : /dto/res1?name=김도이&age=27
    @GetMapping("/dto/res1")
    @ResponseBody
//    @ModelAttribute UserDTO userDTO
//    - 요청 파라미터를 DTO 객체에 바인딩
//    - 폼 input name 속성들 (name, age)이 userDTO 필드명과 일치하면 자동 매핑
//        -> 매핑? dto의 setter를 사용
//        -> ?name=s&age=1 -> setName("s"), setAge(1)
    public String dtoRes1(@ModelAttribute UserDTO userDTO) {
//        req ex) /dto/res1?name=김도이&age=27
        System.out.println("[GET] userDTO (name) = "+userDTO.getName());
        System.out.println("[GET] userDTO (age) = "+userDTO.getAge());

        return userDTO.getName()+" "+userDTO.getAge();
    }

//    #9 : /dto/res2
    @PostMapping("/dto/res2")
    @ResponseBody
//    @ModelAttribute 어노테이션 생략 가능
//    - 파라미터의 UserDTO 타입 앞에 아무것도 없으면 @ModelAttribute 어노테이션 자동 추가됨
//    - POST 방식이므로 폼 데이터를 자동으로 UserDTO에 바인딩

    public String dtoRes2(UserDTO userDTO) {
        System.out.println("[POST] userDTO (name) = "+userDTO.getName());
        System.out.println("[POST] userDTO (age) = "+userDTO.getAge());

        return userDTO.getName()+" "+userDTO.getAge();
    }

//    #10 : /dto/res3
    @PostMapping("/dto/res3")
    @ResponseBody
//    @RequestBody 어노테이션
//    - 요청의 본문 (req.body)에 있는 데이터를 읽어와서 객체에 매핑
//        -> 매핑? 필드에 값을 주입
//    - 반환 값을 HTTP 본문에 직접 작성하게 함
//    - (전제 조건) 단!!!!! 요청의 형식이 JSON 또는 XML 일 때 사용
    
//    415 에러 발생
//    : 서버가 클라이언트로부터 받은 요청의 미디어타입(Content-Type)을 지원하지 않거나 이해할 수 없는 경우 발생
    
//    즉 해당 요청은 MIME Type이 "application/x-www-form-urlencoded" (JSON이나 XML이 아님)
//    -> @RequestBody 어노테이션 사용시 오류 발생됨

//    오류가 안나게 하려면?
//    1. "일반 폼 전송"을 하고 있으니 @ModelAttribute를 사용 -> #9 번 폼
//    2. 클라이언트 측에서 js코드를 사용해 폼 데이터를 JSON 변환하여 전송 -> 동적 폼 전송
    public String dtoRes22(@RequestBody UserDTO userDTO) {
        System.out.println("[POST] userDTO (name) = "+userDTO.getName());
        System.out.println("[POST] userDTO (age) = "+userDTO.getAge());

        return userDTO.getName()+" "+userDTO.getAge();
    }

}