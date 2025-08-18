package _05_class._e_abstract;

public class ShapeEx {
    public static void main(String[] args) {
//        Shape test = new Shape("red");
        // shape 클래스는 abstract 이기 때문에 실제 인스턴스 생성 불가
        Circle circle = new Circle("red");
        Square square = new Square("blue", "마름모");

        System.out.println("====== 원 ======");
        circle.start(); // Shape 추상클래스의 일반 메소드
        circle.draw();  // 추상메소드, Circle 클래스에서 재정의
        System.out.println("원의 색깔은 "+circle.getColor());    // Shape 추상클래스의 일반메소드

        System.out.println("====== 사각형 ======");
        square.start();
        square.draw();
        square.showType();  // Square 클래스의 일반 메소드
        System.out.println("사각형의 종류는 "+square.getType()+", 색깔은 "+square.getColor());

    }
}
