package _08_dependency_injection.after;

// 게시글 저장 인터페이스
public interface IBoardPersistence {
    void save();
    void delete();
}