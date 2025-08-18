package _05_class._f_interface;

interface Move{
    void moveForward();
    void moveBackward();
}

interface Power{
    void powerOn();
    void powerOff();
}

// 인터페이스는 인터페이스를 상속받을 수 있음
interface Car extends Move, Power{  // 다중 상속 가능
    void changeGear(int gear);
}

class Suv implements Car{
    @Override
    public void changeGear(int gear) {
        System.out.println("기어 변경: "+gear);
    }

    @Override
    public void moveForward() {
        System.out.println("전진");
    }

    @Override
    public void moveBackward() {
        System.out.println("후진");
    }

    @Override
    public void powerOn() {
        System.out.println("시동켜기");
    }

    @Override
    public void powerOff() {
        System.out.println("시동끄기");
    }
}

public class Interface01{
    public static void main(String[] args) {
        Suv mySUV = new Suv();
        mySUV.powerOn();
        mySUV.changeGear(2);
        mySUV.moveForward();
        mySUV.changeGear(1);
        mySUV.powerOff();
    }
}
