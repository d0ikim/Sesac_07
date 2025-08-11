package _03_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListPractice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> stringList = new java.util.ArrayList<>();

        System.out.println("문자열을 입력해주세요. \n종료를 원한다면 'exit'을 입력하세요.");
        while(true) {
            System.out.print("입력하세요: ");
            String input = scan.nextLine();

            if(input.equals("exit")){
                break;
            }

            stringList.add(input);
        }
        System.out.println("입력 문자열 리스트");
        for(String word: stringList) {
            System.out.println(word);
        }

        scan.close();
    }
}
