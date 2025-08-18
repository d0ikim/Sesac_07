package _05_class._e_abstract;

public class Circle extends Shape{
    private double radius;

    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double r){
        this.radius = r;
    }

    // 추상메소드 실제 구현
    @Override
    void calculateArea(){
        System.out.println("도형의 넓이: "+getRadius()*getRadius()*Math.PI);
    }
}
