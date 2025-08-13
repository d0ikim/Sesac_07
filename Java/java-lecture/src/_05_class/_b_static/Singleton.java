package _05_class._b_static;

/*
* Singleton, 단 하나의 객체! [싱글톤 패턴]
* - 애플리케이션에서 단 하나의 객체를 만들고 싶을 때 사용하는 패턴
* - private 접근 제한자를 이용해 생성자 만듬 -> 외부에서 인스턴스를 생성할 수 없도록
* - 싱글톤 패턴이 제공하는 static 멤버를 통해 간접적으로 객체를 얻음
*
 */

public class Singleton {
    private static Singleton singleton = new Singleton();   // 싱글톤 객체가 곧 필드

    private Singleton(){
    }

    // singleton 객체 getter
    public static Singleton getSingleton(){
        return singleton;
    }
}
