package _05_class._b_static;

public class SingletonEx {
    public static void main(String[] args) {
//        Singleton s1 = new Singleton(); // private 생성자라서 인스턴스 생성 불가능

        Singleton s2 = Singleton.getSingleton();
        Singleton s3 = Singleton.getSingleton();

        if(s2==s3){
            System.out.println("같은 객체 입니다.");
            System.out.println(s2);
            System.out.println(s3);
        } else {
            System.out.println("다른 객체 입니다.");
        }
    }
}
