package _05_class._f_interface;

public class MusicPlayer {
    public static void main(String[] args) {
        Music music = new Mp3Player();
        System.out.println("==== MP3 Player ====");
        music.play("아이유 블루밍");
        music.stop("아이유 블루밍");

        music = new CdPlayer();
        System.out.println("==== CD Player ====");
        music.play("아이유 꽃갈피");
        music.stop("아이유 꽃갈피");
    }
}
