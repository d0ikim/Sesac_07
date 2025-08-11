package _02_control_statement;

public class MethodOverloading {
    /*
     * 메소드 오버로딩?
     * - 하나의 클래스에서 동일한 이름의 메서드를 여러 개 정의 할 수 있음
     * - 함수의 이름은 같으나 매개변수의 타입, 개수, 함수의 리턴타입을 다르게 할 수 있는 것
     * - 함수의 동작이 유사할 때 사용 가능
     */
    public static void main(String[] args) {
        MethodOverloading ol = new MethodOverloading();

        System.out.println(ol.add(1,2));
        System.out.println(ol.add(1,2,3));
        System.out.println(ol.add(1.2,2.3));
        System.out.println(ol.add(1.1,2.2,4.4));
        System.out.println(ol.add("hello","world"));
    }

    // 메소드 오버로딩: 함수의 이름은 같고, 매개변수의 개수와 타입이 다름
    public int add(int a, int b){
        return a+b;
    }

    public double add(double a, double b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a+b+c;
    }

    public double add(double a, double b, double c){
        return a+b+c;
    }

    public String add(String a, String b){
        return a+b;
    }
}
