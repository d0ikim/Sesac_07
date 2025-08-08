package _01_basic_syntax;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // Scanner 객체 생성
        System.out.println("공백으로 구분하여 이름/나이/키/결혼여부를 입력해주세요.");
        String name = scan.next();
        int age = scan.nextInt();   // 정수 읽기
        double height = scan.nextDouble();  // 실수 읽기
        boolean single = scan.nextBoolean();    // 논리값 읽기
        scan.close();

        System.out.println("=== 입력 결과 출력 ===");
        System.out.println("이름: "+name);
        System.out.println("나이: "+age);
        System.out.println("키: "+height);
        System.out.println("결혼여부: "+single);
    }
}
