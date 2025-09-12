package _09_others.lambda_stream;

// 스트림 (Stream)
// - 데이터 처리 파이프라인
// - 데이터를 반복문 없이 선언적(무엇을 할지 중심으로)으로 다룰 수 있게 함
// - 단계: (1) 스트림 생성
//      -> (2) 중간 연산(filter, map, sorted, distinct, limit)
//      -> (3) 최종 연산(collect, forEach, reduce, count 등)
// - 메서드를 연결해서 사용하는 "체이닝"이 기능

import java.util.Arrays;
import java.util.List;

public class StreamEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("새우깡", "프링글스", "빈츠", "홈런볼");

//        forEach(): 최종 연산, 스트림의 각 요소를 꺼내 실행
        names.stream()
                .forEach(n -> System.out.println("이름: "+n));

//        filter(): 조건을 만족하는 데이터만 남기기
        System.out.println("\n-- filter ---");
        names.stream()
                .filter(n -> n.startsWith("새"))
                .forEach(System.out::println);

//        map(): 데이터를 변환
        System.out.println("\n--- map ---");
        names.stream()
                .map(n-> n+" ("+n.length()+"글자)")
                .forEach(System.out::println);

//        sorted(): 정렬
        System.out.println("\n--- sorted ---");
        names.stream()
                .sorted()
                .forEach(System.out::println);

//        distinct(): 중복 제거
        System.out.println("\n--- distinct ---");
        List<Integer> nums = Arrays.asList(4,2,5,5,6,7,7,8,32,1,8,6);
        nums.stream()
                .distinct()
                .forEach(System.out::println);

//        응용) 파이프라인
        System.out.println("\n--- (응용)짝수만 추출 -> 제곱 -> 중복 제거 -> 정렬 ---");
        nums.stream()
                .filter(n -> n % 2 == 0) // 짝수 선택
                .map(n -> n * n)  // 제곱
                .distinct() // 중복제거
                .sorted()   // 정렬
                .forEach(System.out::println);

    }
}
