package _05_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Rectangle> recArrList = new ArrayList<>();

        while(true){
            System.out.println("사각형의 가로와 세로 길이를 띄어쓰기를 기준으로 입력해주세요.");
            int width = scan.nextInt();
            int height = scan.nextInt();

            if (width==0 && height==0) {
                break;
            } else {
                Rectangle rec = new Rectangle(width);
                rec.setHeight(height);
                recArrList.add(rec);
            }
        }
        for(Rectangle elem: recArrList) {
            System.out.println("가로 길이는 : " + elem.getWidth());
            System.out.println("세로 길이는 : " + elem.getHeight());
            System.out.println("넓이는 : " + elem.area());
            System.out.println("----------------------------");
        }

        scan.close();
    }
}
