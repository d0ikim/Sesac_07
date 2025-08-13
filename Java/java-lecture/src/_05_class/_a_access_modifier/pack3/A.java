package _05_class._a_access_modifier.pack3;

public class A {
    // 필드
    public int field1;
    int field2; // default
    private int field3;

    public A(){
        this.field1 = 1;
        this.field2 = 2;
        this.field3 = 3;

        method1();
        method2();
        method3();
    }

    public void method1(){
        System.out.println("method1");
    }

    void method2(){ // default
        System.out.println("method2");
    }

    private void method3(){
        System.out.println("method3");
    }
}
