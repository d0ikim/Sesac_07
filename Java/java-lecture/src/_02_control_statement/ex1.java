package _02_control_statement;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("숫자 두 개를 입력하세요");
//        int a = scan.nextInt();
//        int b = scan.nextInt();
        System.out.println("반지름이 5인 원의 넓이: "+area(5));
        System.out.println("가로 4, 세로 7인 직사각형의 넓이: "+area(4,7));
        System.out.println("밑변 6, 높이 3인 삼각형의 넓이: "+area(6,3,true));

//        scan.close();
    }

    public static double area(int radius){
        return Math.pow(radius,2)*Math.PI;
    }

    public static double area(int width, int height){
        return width*height;
    }

    public static double area(double bottom, double height, boolean isTriangle){
        return bottom*height/2;
    }
}
