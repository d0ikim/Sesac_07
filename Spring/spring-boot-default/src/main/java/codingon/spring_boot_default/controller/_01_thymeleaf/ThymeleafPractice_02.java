package codingon.spring_boot_default.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ThymeleafPractice_02 {
    @GetMapping("/people")
    public String getPeople(Model model){
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("kim", 10));
        list.add(new Person("lee", 20));
        list.add(new Person("hong", 30));
        list.add(new Person("park", 40));
        list.add(new Person("shin", 50));

        model.addAttribute("list",list);

        return "_01_thymeleaf/practice_02";
    }

    class Person{
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
