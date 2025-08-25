package codingon.spring_boot_default.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafPractice {
    @GetMapping("/practice")
    public String getPractice(Model model){
        model.addAttribute("age", 10);
        model.addAttribute("age2", 20);

        return "_01_thymeleaf/practice";
    }
}
