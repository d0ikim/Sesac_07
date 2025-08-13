package _05_class._a_access_modifier.pack4;

import _05_class._a_access_modifier.pack3.A;

public class C {
    public static void main(String[] args) {
        A a = new A();
        a.field1 = 111; // public, 다른 패키지에서 접근 가능!
        System.out.println("a filed1 = "+a.field1);

//        a.field2 = 222;   // default와
//        a.field3 = 222;   // private은 다른 패키지에서 접근 불가

        a.method1();
//        a.method2();  // default와
//        a.method3();  // private은 다른 패키지에서 접근 불가

    }
}
