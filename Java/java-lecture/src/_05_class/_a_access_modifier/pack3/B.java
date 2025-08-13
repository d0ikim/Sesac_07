package _05_class._a_access_modifier.pack3;

public class B {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.field1);   // public
        System.out.println(a.field2);   // default
//        System.out.println(a.field3);   // private, 접근 불가

        a.field1 = 11;
        a.field2 = 22;
//        a.field3 = 33;  // 변경도 불가

        a.method1();    // public
        a.method2();    // default
//        a.method3();    // private, 접근 불가능
    }
}
