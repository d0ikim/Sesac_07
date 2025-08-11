package _02_control_statement;

// method 정의 방법

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * [접근제한자] [static] [return type] [함수명](인자1, 인자2, ..) {}
 * // 함수의 내용
 * // return ...
 *
 */
public class Method {
    public static void main(String[] args) {
        hello();
        System.out.println(sum1(1,2));
        System.out.println(connect("안녕","하세요"));

        int number = 10;            // primitive type
        int[] numbers = {10,20};    // reference type

        // call by value, call by address
        // 1. call by value
        // - primitive 타입을 함수의 인자로 전달하는 경우
        // - 값을 함수의 인자로 전달하기 때문에 원래 값은 변경되지 않는다.
        System.out.println("함수에 들어가기 전 value: "+number);
        System.out.println("함수의 리턴값: "+multi10(number));
        System.out.println("함수를 거치고 난 후: "+number);

        // 2. call by address
        // - reference 타입을 함수의 인자로 전달
        // - 변수가 저장되어 있는 "주소"를 전달, 
        // - 함수 내부에서 전달된 변수를 변경하는 부분이 있다면 원래의 값도 같이 변경
        //   (같은 주소 참조하고 있기 때문)
        System.out.println(numbers);    // [I@58372a00 : 주소 출력
        System.out.println("함수 들어가기 전 value: "+Arrays.toString(numbers));
        System.out.println("함수의 리턴값: "+Arrays.toString(multi10_2(numbers)));
        System.out.println("함수를 거치고 난 후: "+Arrays.toString(numbers));
    }

    // 반환값이 없는 메소드: void
    public static void hello(){
        System.out.println("hello~!");
    }

    public static int sum1(int x, int y){
        System.out.println("sum1 호출..");
        return x+y;
    }

    public static String connect(String a, String b){
        return a+b;
    }

    public static int multi10(int x){
        x*=10;
        return x;
    }

    public static int[] multi10_2(int[] numbers){
        for(int i=0; i<numbers.length; i++) {
            numbers[i] *=10;
        }
        return numbers;
    }
}
