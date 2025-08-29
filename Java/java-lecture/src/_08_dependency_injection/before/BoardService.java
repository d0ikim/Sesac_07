package _08_dependency_injection.before;

// 게시판 목록을 관리하는 기능을 제공하는 클래스
public class BoardService {
//    private final FileBoardPersistence persistence;
    private final DbBoardPersistence persistence;

    public BoardService(){
//        this.persistence = new FileBoardPersistence();  // 파일에 게시판 글 목록을 저장하는 클래스 생성
        this.persistence = new DbBoardPersistence();    // 데이터베이스에 게시판 글 목록을 저장하는 클래스 생성
    }

    public void save() { persistence.save(); }
    public void delete() { persistence.delete(); }
}