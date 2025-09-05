package codingon.spring_boot_jpa.repository;

import codingon.spring_boot_jpa.dto.BoardDTO;
import codingon.spring_boot_jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    특정 작성자의 게시판 글 조회
    @Query("SELECT b FROM Board b WHERE b.writer = :writer")
    List<Board> findAllByWriter(@Param("writer") String writer);
}
