package _05_class;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("사각형의 가로와 세로 길이를 띄어쓰기를 기준으로 입력해주세요.");
        Rectangle rec = new Rectangle(scan.nextInt(), scan.nextInt());

        System.out.println(rec.area());
    }
}
