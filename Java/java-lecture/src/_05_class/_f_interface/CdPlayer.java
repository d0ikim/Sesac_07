package _05_class._f_interface;

public class CdPlayer implements Music{
    @Override
    public void play(String album) {
        System.out.println("CD 플레이어에서 '"+album+"' 앨범을 재생합니다.");
    }

    @Override
    public void stop(String album) {
        System.out.println("CD 플레이어에서 '"+album+"' 앨범을 정지합니다.");
    }
}
