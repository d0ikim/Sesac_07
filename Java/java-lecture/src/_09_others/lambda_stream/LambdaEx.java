package _09_others.lambda_stream;

// 람다 표현식 (Lambda Expression)
// - 익명 함수를 간단하게 표현하는 방법
// - 문법: java(매개변수) -> { 실행코드 }

import java.util.Arrays;
import java.util.List;

public class LambdaEx {
    public static void main(String[] args) {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 1");
            }
        };
        run1.run();


//        람다 표현식
        Runnable run2 = () -> System.out.println("Hello World 2");
        run2.run();

        List<String> names = Arrays.asList("바나나", "키위", "오렌지");
        names.forEach(name -> System.out.println(name));    // 매개변수를 갖는 람다 표현식
        
//        람다를 사용하지 않고 일반 for문을 사용한 경우
//        for (String name: names) {
//            System.out.println(name);
//        }
        
//        메서드 참조 (Method Reference)
//        :: 란? 람다식 축약 표현으로 람다식이 "그 메서드만 실행" 하는 경우 -> :: 로 간단히 쓸 수 있음
//        -> 가독성이 좋아지고 코드가 더 깔끔해짐
//        ex) 클래스이름::메서드이름, 객체참조::메서드이름
        names.forEach(System.out::println); // 26번줄을 똑같이 메서드참조로 변경한 경우
    }
}
