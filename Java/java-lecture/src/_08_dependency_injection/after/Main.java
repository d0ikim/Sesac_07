package _08_dependency_injection.after;

// 의존성 주입
public class Main {
    public static void main(String[] args) {
//        IBoardPersistence persistence = new FileBoardPersistence();   // 인터페이스를 만들어주어서, 거기에 생성자로 File쓸건지,
        IBoardPersistence persistence = new DbBoardPersistence();   // Db쓸건지만 바꿔주면 됨
//        -> 파일에서 데이터베이스로 저장방식이 변경되었는데, (즉, persistence 타입이 바뀜)
//        서비스(BoardService) 코드를 변경하지 않아도 됨!!

//        1. 생성자를 이용한 의존성 주입방식
//        BoardService service = new BoardService(persistence);  // 게시판 목록을 관리하는 기능을 제공하는 인스턴스 생성

//        2. setter를 이용한 의존성 주입방식
        BoardService service = new BoardService();
        service.setIBoardPersistence(persistence);

        service.save();
        service.delete();
    }
}