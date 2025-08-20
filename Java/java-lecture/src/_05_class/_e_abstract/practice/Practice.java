package _05_class._e_abstract.practice;

import _05_class._a_access_modifier.pack2.C;

import java.util.ArrayList;
import java.util.List;

abstract class Shape{
    private String color;
    private String type;

    public Shape(String color, String type){
        this.color = color;
        this.type = type;
    }

    // 추상메소드
    public abstract double calculateArea();

    // 일반메소드
    public String getColor(){
        return this.color;
    }
    public String getType(){
        return this.type;
    }
}

class Circle extends Shape{
    private double radius;

    public Circle(String color, String type, double radius){
        super(color, type);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color, String type, double width, double height){
        super(color, type);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width*height;
    }
}

public class Practice {
    public static void main(String[] args) {
        Circle c1 = new Circle("red","circle",10.0);
        Rectangle r1 = new Rectangle("blue","rectangle",5.0,5.0);

        List<Shape> list = new ArrayList<>();
        list.add(c1);
        list.add(r1);

        for(Shape s: list){
            System.out.println("=== 도형의 정보: "+s.getType()+" ===");
            System.out.println("도형의 색상: "+s.getColor());
            System.out.println("도형의 넓이: "+s.calculateArea());
        }
    }
}
