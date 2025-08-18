package _05_class._f_interface;

public class Television implements RemoteControl{
    private int volume;

    // turnOn, turnOff, setVolume(int v) 세 개의 추상메소드를 가지고 있는 interface
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int v) {
        if(v > RemoteControl.MAX_VOLUME){
            volume = RemoteControl.MAX_VOLUME;  // 매개변수와 필드명이 다를땐 구분가능하므로, this. 생략 가능
        } else if(v < RemoteControl.MIN_VOLUME){
            volume = RemoteControl.MIN_VOLUME;
        } else{
            // 정상 volume 범위
            volume = v;
        }
        System.out.println("현재 TV의 volume: "+this.volume);
    }
}
