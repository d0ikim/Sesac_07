package _05_class._b_static;

/*
 * static 멤버
 * - 객체를 생성하지 않아도 클래스를 통해서 바로 접근 가능
 *      > new ClassName() 를 통해 객체생성 하지 않아도 됨
 * - 클래스이름.필드이름, 클래스이름.메소드이름(), dot(.) 연산자로 접근 가능
 * - this 는 사용 불가
 */
public class Calculator {
    static double pi = 3.141592;

    static int plus(int x, int y){
        return x+y;
    }

    static int minus(int x, int y){
        return x-y;
    }
}
