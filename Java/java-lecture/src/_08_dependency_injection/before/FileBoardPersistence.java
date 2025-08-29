package _08_dependency_injection.before;

// 파일에 게시판 글 목록을 저장하는 클래스
public class FileBoardPersistence {
//    영속성(Persistence) : 데이터나 객체의 상태를 지속적으로 저장하여 프로그램이 종료되거나 시스템이 재부팅되더라도 그 상태가 유지되는 것을 의미 = 데이터를 영구적으로 저장하는 능력
    public void save() {
        System.out.println("파일에 게시글 저장 중...");
    }
    public void delete() {
        System.out.println("파일에 저장된 게시글 삭제 중...");
    }
}