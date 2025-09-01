package codingon.spring_boot_mybatis.mapper;

import codingon.spring_boot_mybatis.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Select("SELECT * FROM board WHERE writer = #{writer}")
    Board findByWriter(String writer);

    @Insert("INSERT INTO board (title, content, writer) values (#{title}, #{content}, #{writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Update("UPDATE board SET title = #{title}, content = #{content}, writer = #{writer} WHERE id = #{id}")
    void update(Board board);


}
