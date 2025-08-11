package _02_control_statement;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("숫자를 입력하세요");
        int num = scan.nextInt();

        for(int i=1;i<num+1;i++) {
            System.out.println(i);
        }

        scan.close();
    }
}
