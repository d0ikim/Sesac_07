package _05_class._f_interface;

public class Execute {
    public static void main(String[] args) {
        RemoteControl rc;   // reference 타입, null 초기화 할 수 있음
        rc = null;
        System.out.println(rc);

        System.out.println("===== Television 객체 생성 =====");
        rc = new Television();  // RemoteControl rc = new Television();
        rc.turnOn();
        rc.setVolume(-2);
        rc.turnOff();

        System.out.println("===== audio 객체 생성 =====");
        rc = new Audio();   // RemoteControl rc = new Audio();
        rc.turnOn();
        rc.setVolume(150);
        rc.turnOff();
    }
}
