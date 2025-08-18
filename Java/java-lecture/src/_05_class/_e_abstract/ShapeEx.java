package _05_class._e_abstract;

import java.util.ArrayList;
import java.util.List;

public class ShapeEx {
    public static void main(String[] args) {
//        Shape test = new Shape("red");
        // shape 클래스는 abstract 이기 때문에 실제 인스턴스 생성 불가
        Circle circle = new Circle("red", 4);
        Rectangle rect = new Rectangle("blue", 4,6);
        List<Shape> arrList = new ArrayList<>();
        arrList.add(circle);
        arrList.add(rect);

        System.out.println("==== Circle 도형의 정보 ====");
        System.out.println("도형의 색상: "+ arrList.get(0).getColor());
        circle.calculateArea();

        System.out.println("==== Rectangle 도형의 정보 ====");
        System.out.println("도형의 색상: "+arrList.get(1).getColor());
        rect.calculateArea();
    }
}
