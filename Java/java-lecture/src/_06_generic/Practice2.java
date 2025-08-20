package _06_generic;

class Calculator<T extends Number>{
    private T num1;
    private T num2;

    public Calculator(T num1, T num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public T getNum1() {
        return num1;
    }
    public T getNum2() {
        return num2;
    }
    public void setNum1(T num1) {
        this.num1 = num1;
    }
    public void setNum2(T num2) {
        this.num2 = num2;
    }

    public double add(){
        // double sum = (double) num1 + (double)num2;   // exception 발생
        // Number는 double 로 캐스팅 불가

        return getNum1().doubleValue() + getNum2().doubleValue();
    }
}

public class Practice2 {
    public static void main(String[] args) {
        Calculator<Integer> calc = new Calculator<>(10,5);
        Calculator<Double> calc2 = new Calculator<>(5.0,0.6400000000001);

        System.out.println("Integer Sum: "+calc.add());
        System.out.println("Double Sum: "+calc2.add());
    }
}
