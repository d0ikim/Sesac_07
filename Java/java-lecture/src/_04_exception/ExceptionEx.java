package _04_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {
    public static String divide(int x, int y){
        return x +"/"+y+"="+(x/y);  // 나누기
    }

    public static int getLength(String str){
        return str.length();    // 문자열의 길이 반환
    }

    public static int getValueByIdx(int[] arr, int idx){
        return arr[idx];    // 배열의 요소를 반환
    }

    public static void main(String[] args) {
        System.out.println(divide(6,2));
//        System.out.println(divide(6,0));    // >
//        System.out.println("여기까지 도착하나요?");

        // ##### case1. 0으로 나누기 [ArithmeticException]
        try {
            System.out.println("나누기 연산 시작!");
            System.out.println(divide(6,2));    // exception 발생
        } catch(ArithmeticException e){
            // e.getMessage() : 에러가 발생한 이유
            // e.toString()   : 에러가 발생한 이유, 예외의 종류
            System.out.println("나누기 중 에러 발생 : "+e.getMessage());
            System.out.println("나누기 중 에러 발생 : "+e.toString());
        } finally {
            System.out.println("나누기 연산 종료!");
        }


        // ##### case2. null 에 접근하려고 할 때 [NullPointerException]
//        System.out.println("단어 길이: "+getLength(new String("hello")));

        try {
            System.out.println("단어 길이: "+getLength(null));  // 예외 발생
        } catch(NullPointerException e) {
            System.out.println("단어길이 확인 중 에러 발생 : "+e.getMessage());
            System.out.println("단어길이 확인 중 에러 발생 : "+e.toString());
        }
        System.out.println("여기까지 오나요?");


        // ##### case3. index 값으로 배열접근시 없는 범위로 접근 [ArrayIndexOutOfBoundsException]
        int[] numbers = {10,20,30,40,50};
        System.out.println(getValueByIdx(numbers,1));   // 20

        try {
            System.out.println(getValueByIdx(numbers,10));
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱싱 중 에러 발생 >> "+e.getMessage());
            System.out.println("배열 인덱싱 중 에러 발생 >> "+e.toString());
        }


        // ##### case4. 입력 형식 오류 [InputMismatchException]
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("정수를 입력하세요.");
            int number = scan.nextInt();
            System.out.println("정수 확인: "+number);
        } catch (InputMismatchException e){
            System.out.println("입력 형식 에러 발생: "+e.getMessage()); // null
            System.out.println("입력 형식 에러 발생: "+e.toString());   // 예외의 종류는 잘 나옴
        }
    }
    /*
    * 다양한 예외 처리 상황
    * 1. catch 여러개 사용 가능
    *   try{ ~ ~ ~
    *   } catch(Exception1 e){
    *   } catch(Exception2 e){
    *   } catch(Exception3 e){
    *   }
    * - 여러 개의 예외를 받아주는 경우, 각 예외마다 처리 방법이 다를 때
    *
    * 2. 하나의 catch에 exception을 여러 개 작성 가능
    *   try {
    *   } catch(Exception1 e | Exception2 e){
    *   }
    * - 여러 개의 예외를 받아줄 때 예외처리가 비슷한 경우
    *
    * 3. Exception 이라는 전체 예외 타입 명시 가능
    *   try {
    *   } catch(Exception e){
    *   }
    * - 웬만하면 디테일한 에러 종류 명시하세요
     */
    
}
