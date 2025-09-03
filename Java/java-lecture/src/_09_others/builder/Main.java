package _09_others.builder;

public class Main {
    public static void main(String[] args) {
//        빌더 패턴을 사용하지 않고, 생성자를 통해서 객체를 생성하는 예시
//        Student std1 = new Student("John", 10, 1, "LA");

//        빌더 패턴을 사용한다면?
//        Student std2 = new Student("John").setAge(5).setGrade(1).setAddress("LA").build();

        Computer com1 = new Computer.ComputerBuilder("Intel i5")
                .setRam(8)
                .setStorage(256)
                .build();
        System.out.println("com1 = "+com1);

        Computer com2 = new Computer.ComputerBuilder("AMD Ryzen 7")
                .setRam(32)
                .setGpu("NVIDIA RTX 3080")
                .setStorage(1000)
                .build();
        System.out.println("com2 = "+com2);


        Car car1 = new Car.CarBuilder("Hyundai").build();
        System.out.println("car1 = "+car1);

        Car car2 = new Car.CarBuilder("Tesla")
                .setModel("Model S")
                .setColor("Red")
                .build();
        System.out.println("car2 = "+car2);

        Car car3 = new Car.CarBuilder("BMW")
                .setModel("X5")
                .setYear(2023)
                .setColor("Black")
                .build();
        System.out.println("car3 = "+car3);
    }
}

// Builder 패턴
// - 객체 생성을 직관적이고 안전하게 만들어주는 디자인 패턴
// - Lombok 라이브러리의 @Builder 어노테이션을 이용하면 자동으로 Builder 클래스를 생성

// 장점
// 1. 가독성 향상
// 2. 유연성: 필요한 데이터만 선택적으로 설정
// 3. 불변성: 객체 생성 후에 변경할 수 없게 만듬
// 4. 매개변수 순서 문제 해결: 생성자의 매개변수 순서를 기억할 필요가 없다!