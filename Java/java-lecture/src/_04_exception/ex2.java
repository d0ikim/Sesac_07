package _04_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        // 1. 배열의 크기 입력 >> 정수형
        Scanner scan = new Scanner(System.in);
        System.out.println("배열의 크기를 입력해주세요.");
        try {
            int arrayLength = scan.nextInt();   // 예외 발생 가능 InputMismatchException
            int[] intArray = new int[arrayLength];  // 예외 발생 가능 NegativeArraySizeException

            if(arrayLength == 0) {
                throw new IllegalArgumentException("0은 입력값으로 올 수 없습니다.");   // 예외 발생시킴
            }

            // 평균 구하기
            int sum = 0;
            for(int i=0;i<arrayLength;i++) {
                System.out.print("입력: ");
                int arrayEl = scan.nextInt();
                intArray[i] = arrayEl;
                sum += arrayEl;
            }

            double avg = (double)sum/arrayLength;
            System.out.println("평균: "+avg);
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
            System.out.println("잘못된 입력형식. 정수를 입력해주세요.");
        } catch(NegativeArraySizeException | IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("배열의 크기는 자연수로 입력해주세요.");
        } finally {
            scan.close();
        }
    }
}
