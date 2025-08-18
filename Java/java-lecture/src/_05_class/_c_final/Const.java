package _05_class._c_final;

import _05_class._a_access_modifier.pack2.C;

public class Const {

    final String name;    // only final, 인스턴스에 속해있는 변수

    static int MIN_VALUE = 0;   // only static, 인스턴스 공유 변수, 수정 불가

    // 정수형 상수 선언
    public static final int MAX_VALUE = 100;

    // 문자열 상수 선언
    public static final String GREETING = "hello, world";

    public Const(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(Const.MAX_VALUE);    // static final
        System.out.println(Const.MIN_VALUE);    // static

        Const.MIN_VALUE = 10;
        System.out.println("변경 후 Min value : "+Const.MIN_VALUE);
//        Const.MAX_VALUE = 90; // final은 재할당 불가능

        Const c1 = new Const("앨리");
        System.out.println(c1.name);    // final
//        c1.name = "doi";  // 마찬가지로 재할당 불가능
    }
}
