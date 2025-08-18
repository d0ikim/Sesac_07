package _05_class._e_abstract;

public class Circle extends Shape{
    public Circle(String color){
        super(color);
    }

    // draw 추상메소드 실제 구현
    @Override
    void draw(){
        System.out.println("원 그리기");
    }
}
