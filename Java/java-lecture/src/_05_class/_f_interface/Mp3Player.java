package _05_class._f_interface;

public class Mp3Player implements Music{
    @Override
    public void play(String song) {
        System.out.println("MP3 플레이어에서 '"+song+"' 음악을 재생합니다.");
    }

    @Override
    public void stop(String song) {
        System.out.println("MP3 플레이어에서 '"+song+"' 음악을 정지합니다.");
    }
}
