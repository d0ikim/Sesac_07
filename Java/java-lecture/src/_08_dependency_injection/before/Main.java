package _08_dependency_injection.before;

// 의존성 주입 전
public class Main {
    public static void main(String[] args) {
        BoardService service = new BoardService();  // 게시판 목록을 관리하는 기능을 제공하는 인스턴스 생성
        service.save();
        service.delete();
    }
}