package _05_class._d_inheritance;

public class Dog extends Animal{
    // Animal 클래스의 멤버
    // species, name, age 필드
    // makeSound() 메소드

    public Dog(String species, String name, int age){
        super(species, name, age);
    }

    void bring(String stuff){
        System.out.println(stuff+"를(을) 가져옵니다.");
    }

//    @Override   // 부모 메소드를 새로운 내용으로 재정의하겠다
//    // @Override? 컴파일러가 정확히 오버라이딩 되었는지 체크함 (생략 가능)
//    // 오버라이딩을 할 때는 함수이름, 함수의리턴타입, 매개변수의 개수와 매개변수의 타입이 모두 일치해야 함
    @Override
    void makeSound(){
//        System.out.println("이름: "+super.name);  // super.변수 로 부모 필드도 접근 가능
        System.out.println("멍멍");
//        super.makeSound();  // 부모의 메소드 호출 가능
        // super 를 사용하면 내용을 그대로 가져올 수 있음
    }
}
