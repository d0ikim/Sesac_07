package _05_class._e_abstract;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color, int width, int height){
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }

    @Override
    void calculateArea() {
        System.out.println("도형의 넓이: "+getWidth()*getHeight());
    }
}
