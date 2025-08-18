package _05_class._e_abstract;

// "도형" 이라는 추상적 개념
// - 도형이라는 추상적인 개념을 바탕으로 원, 사각형, 삼각형 등의 실체를 만들 수 있음
// - 추상클래스 내부의 멤버는 원, 사각형, 삼각형 등에 공통적으로 사용될 필드와 메소드를 미리 선언
public abstract class Shape {
    String color;

    public Shape(String color){
        this.color = color;
    }

    void start(){
        System.out.println("도형 그리기 시작");
    }
    String getColor(){
        return this.color;
    }

    // 추상 메소드
    abstract void draw();
}
