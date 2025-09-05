package _09_others.wrapper;

import java.util.Optional;

// Optional 타입
// - 값이 있을수도 있고, 없을 수도 있는 상황을 null 대신 표현
public class OptionalEx {
    public static void main(String[] args) {
//        값이 존재하는 Optional 생성
//        of(): 생성, isPresent(): 값 조회/확인
        Optional<String> opt1 = Optional.of("Hello~!");
        System.out.println("opt1 이 존재하는가? "+ opt1.isPresent()); // true

//        값이 null 일 수도 있는 경우 (null 이면 empty Optional 생성)
//        ofNullable(): 생성, isEmpty(): 값 조회/확인
        Optional<String> opt2 = Optional.ofNullable(null);
        System.out.println("opt2 가 비어있는가? "+opt2.isEmpty());    // true

//        비어있는 Optional 생성
//        empty(): 생성
        Optional<String> opt3 = Optional.empty();
        System.out.println("opt3 가 비어있는가? "+opt3.isEmpty());    // true

//        값 꺼내기 (값이 없으면 예외 발생)
        System.out.println("opt1 = "+opt1.get());
//        System.out.println("opt2 = "+opt2.get());   // NoSuchElementException 발생

//        값이 없으면 기본값 제공
        String value1 = opt1.orElse("default value");
        System.out.println("value1 = "+value1);   // value1 = Hello~!
        String value2 = opt2.orElse("default value");
        System.out.println("value2 = "+value2);   // value2 = default value
    }
}
