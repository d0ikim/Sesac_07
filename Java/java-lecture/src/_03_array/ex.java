package _03_array;

import java.util.Scanner;

public class ex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = new String[10];
        int i=0;

        while (true) {
            System.out.println("문자를 입력해주세요 : ");
            arr[i] =scan.nextLine();

            if (arr[i].equals("exit")) {
                break;
            }
            i++;
        }

        for(int j=0; j<i; j++) {
            System.out.println(arr[j]);
        }
        scan.close();
    }
}
