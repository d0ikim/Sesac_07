package _05_class._a_access_modifier.pack1;

// 접근제한자 public 생략 => default 접근 제한자(같은 패키지에서 접근 가능)
class A {
    void printA(){  // default 접근 제한자
        System.out.println("hi, I am pack1's A class");
    }

}
