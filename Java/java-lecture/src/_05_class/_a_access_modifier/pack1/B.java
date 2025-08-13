package _05_class._a_access_modifier.pack1;

public class B {
    public static void main(String[] args) {
        A instanceA = new A();
        System.out.println("B 클래스 내부입니다.");
        instanceA.printA();
    }
}
