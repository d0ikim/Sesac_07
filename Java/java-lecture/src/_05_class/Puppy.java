package _05_class;

public class Puppy {
    // 생성자 생략 가능 => 매개변수를 받지 않는 경우에만
//    public Puppy() {
//    }

    public void printInfo(String name) {
        System.out.println("puppy's name is "+name);
    }

    public void printInfo(String name, int age) {
        System.out.println("name: "+name);
        System.out.println("age: "+age);
    }
}
