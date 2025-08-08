package _01_basic_syntax;

public class DataTypes {
    public static void main(String[] args) {
        System.out.println("=== Primitive Type ===");
        int a = 11;
        long b = 10000;
        float c = 3.14f;    // float 타입은 반드시 선언시 f를 뒤에 붙여줘야 함
        double d = 2.71828;

        // 문자형 변수 선언
        char ch = 'A';
        // 논리형 변수 선언
        boolean bool = true;

        System.out.println("정수형 변수: " + a +", " + b);
        System.out.println("실수형 변수: " + c +", " + d);
        System.out.println("문자형 변수: " + ch);
        System.out.println("논리형 변수: " + bool);

        /////////////////////////////////////////////////////////////////
        System.out.println("=== Reference Type ===");
        // 1. primitive에도 있는 자료형
        Integer aa = 11;
        Long bb = 3000000000L;  // Long 타입은 반드시 L을 뒤에 붙여줘야 함
        // int의 범위 2^31 기준 : 21억 4700만~~~
        // int 범위 밖 수를 저장할 때는 숫자 뒤에 'l' 또는 'L'
        Short cc = 30000;
        Byte dd = 127;
        Float ee = 3.141592F;
        Double ff = 2.7182888;
        Character chch = '@';
        Boolean boo = false;

        System.out.printf("Integer: %d, Long: %d, Short: %d, Byte: %d, Float: %.6f, Double: %.7f, Character: %c, Boolean: %b \n", aa, bb, cc, dd, ee, ff, chch, boo);

        // 2. Reference 타입에만 있는 자료형
        // 문자열
        String greeting = "hello, world!";

        // 배열
        int[] numbers = {1,2,3,4,5};

        // 인스턴스
        Person person = new Person("john", 40);

        System.out.println("String 변수: "+ greeting);
        System.out.println("배열 변수: ");
        for(int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        System.out.println("클래스로 만들어진 객체 출력");
        System.out.println("Person 객체의 정보: "+person.getName() +", "+ person.getAge());

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}