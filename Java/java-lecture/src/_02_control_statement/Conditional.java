package _02_control_statement;

import java.util.Scanner;

public class Conditional {
    public static void main(String[] args) {
        int number=10;
        if(number%2==0){
            System.out.println("짝수");
        } else{
            System.out.println("홀수");
        }

        if(number%3==0){
            System.out.println("3의 배수");
        } else if (number%5==0) {
            System.out.println("5의 배수");
        } else {
            System.out.println("3의 배수도, 5의 배수도 아니에요..");
        }

        // switch 문
        String dayOfWeek;
        int day=7;
        switch (day){
            case 0:
                dayOfWeek = "일요일";
                break;
            case 1:
                dayOfWeek = "월요일";
                break;
            case 2:
                dayOfWeek = "화요일";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                dayOfWeek="수 ~ 토요일";
                break;
            default:
                dayOfWeek = "잘못된 입력입니다.";
        }

        System.out.println("오늘은 "+dayOfWeek);

        // switch 표현식(java에만 있음 jdk-14(2020) 부터 채택)
        // 끝에 ; 붙여줘야함 표현식이라
        String yoil = switch (day){
            case 1,2,3,4,5 -> "평일";
            case 0,6 -> "주말";
            default -> {
                // 여러줄 실행하고 싶으면 중괄호 블록으로 묶어서 사용!
                System.out.println("잘못된 입력값입니다.");
                yield "알 수 없음"; // 스위치 표현식을 만들며 도입된 키워드 (return 같은)
            }
        };

        System.out.println("오늘은 "+ yoil +"입니다.");

        System.out.println("======== 문자열 비교 =========");
        System.out.println("이름을 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        scan.close();

        System.out.println("이름 확인: "+name);
        if (name.equals("allie")){
            System.out.println("allie님 환영합니다!");
        } else {
            System.out.println("이름을 다시 확인해주세요!");
        }

        System.out.println("==== 문자열 리터럴 ====");
        String str1 = "hello, world";
        String str2 = "hello, world";   // 문자열 리터럴: 큰따옴표로 둘러싸인 문자의 연속(문자열 값 직접 표현)
        /**
         * 동일한 문자열 리터럴 -> Java에서 String pool 이라는 공유 메모리 영역에 문자열 저장
         * 위의 경우에는 str1과 str2가 동일한 문자열이기 때문에 공유된 주소를 사용!
         */
        if(str1==str2){
            System.out.println("서로 같은 참조를 가리킵니다.");
        } else {
            System.out.println("서로 다른 참조를 가리킵니다.");
        }

        if(str1.equals(str2)){
            System.out.println("서로 내용이 같아요.");
        } else {
            System.out.println("서로 내용이 달라요.");
        }

        System.out.println("==== 문자열 객체 ====");
        String str3 = new String("hello, world");   // 문자열 객체
        String str4 = new String("hello, world");   // 문자열 객체
        // 서로 다른 객체를 생성하는 중
        if (str3==str4){
            System.out.println("서로 같은 참조를 가리킵니다.");
        } else {
            System.out.println("서로 다른 참조를 가리킵니다.");
        }

        if (str3.equals(str4)){
            System.out.println("내용이 같습니다.");
        } else {
            System.out.println("내용이 다릅니다.");
        }
    }
}
