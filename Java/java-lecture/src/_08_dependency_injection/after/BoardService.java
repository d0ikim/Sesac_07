package _08_dependency_injection.after;

// 게시판 목록을 관리하는 기능을 제공하는 클래스
public class BoardService {
//    1. 생성자를 이용한 의존성 주입
//    private final IBoardPersistence persistence;    // 필드를 인터페이스의 타입으로 선언
//
//    public BoardService(IBoardPersistence persistence) {
//        this.persistence = persistence;
//    }


//    2. setter를 이용한 의존성 주입
    private IBoardPersistence persistence;

    public void setIBoardPersistence(IBoardPersistence persistence) {
        this.persistence = persistence;
    }

    public void save() { persistence.save(); }
    public void delete() { persistence.delete(); }
}