package _05_class._d_inheritance;

public class StudentEx {
    public static void main(String[] args) {
        // Case 1. public 필드인 경우
        /*
        Student std1 = new Student("rumon", 30, "영등포");

        System.out.println(std1.name);
        System.out.println(std1.age);
        System.out.println(std1.campus);

        // Person 부모 클래스로부터 상속받은 메소드
        std1.say();
        std1.eat("banana");
        // Student 자식 클래스에서 선언한 메소드
        std1.setCampus("ydp");
        */

        // Case 2. private 필드인 경우
        Student std2 = new Student("rumon", 30);
//        System.out.println(std2.name);  // 필드에 직접 접근 불가 (private)
        System.out.println("std2의 이름: "+std2.getName());
        System.out.println("std2의 나이: "+std2.getAge());
        System.out.println("std2의 캠퍼스: "+std2.getCampus());

        // Person 으로부터 상속받은 메소드
        std2.say();
        std2.eat("apple");

        // Student 만의 메소드
        std2.setCampus("영등포");
        System.out.println("std2의 캠퍼스: "+std2.getCampus());
    }
}

