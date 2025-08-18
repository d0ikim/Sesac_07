package _05_class._c_final;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("원의 반지름을 입력하세요: ");
        Circle c1 = new Circle(scan.nextInt());

        c1.calculateArea();

        scan.close();
    }
}

class Circle {
    private final double PI = Math.PI;
    private final double radius;

    public Circle(double radius){
        this.radius = radius;
        System.out.println("원의 반지름: "+this.radius);
    }

    public double getPI() {
        return this.PI;
    }
    public double getRadius(){
        return this.radius;
    }

    public void calculateArea() {
        System.out.println("원의 넓이: "+getRadius()*getRadius()*getPI());
    }
}