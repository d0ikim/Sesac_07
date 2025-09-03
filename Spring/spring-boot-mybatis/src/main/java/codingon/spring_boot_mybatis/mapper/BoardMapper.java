package codingon.spring_boot_mybatis.mapper;

import codingon.spring_boot_mybatis.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
//    case1. 어노테이션 기반 매퍼
    /*
    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Select("SELECT * FROM board WHERE writer = #{writer}")
    Board findByWriter(String writer);

    @Insert("INSERT INTO board (title, content, writer) values (#{title}, #{content}, #{writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Update("UPDATE board SET title = #{title}, content = #{content}, writer = #{writer} WHERE id = #{id}")
    void update(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    void delete(int id);
    */

//    case2. XML 기반 매퍼
    List<Board> findAll();
    Board findByWriter(String writer);
    void insert(Board board);
    void update(Board board);
    void delete(int id);
}
