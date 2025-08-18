package _05_class._f_interface;

public class Audio implements RemoteControl{
    private int volume;

    // turnOn, turnOff, setVolume(int v) 세 개의 추상메소드를 가지고 있는 interface
    @Override
    public void turnOn() {
        System.out.println("리모컨으로 Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("리모컨으로 Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUME){
            this.volume = RemoteControl.MAX_VOLUME;
        } else if(volume < RemoteControl.MIN_VOLUME){
            this.volume = RemoteControl.MIN_VOLUME;
        } else{
            this.volume = volume;
        }

        System.out.println("Audio 의 현재 볼륨: "+this.volume);

    }
}
