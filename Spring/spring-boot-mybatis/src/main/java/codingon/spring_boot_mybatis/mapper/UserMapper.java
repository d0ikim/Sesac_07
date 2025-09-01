package codingon.spring_boot_mybatis.mapper;

import codingon.spring_boot_mybatis.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // 해당 인터페이스가 MyBatis의 mapper 임을 나타냄
public interface UserMapper {

//    case1. 어노테이션 기반 매퍼
//    - 간단한 SQL(쿼리)의 경우 간결하게 표현
//    - Java 코드 내에서 SQL 문을 직접 볼 수 있어 즉각적인 이해 가능
//    - @Select, @Insert, @Update, @Delete 어노테이션 사용
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users where id = #{id}")
    User findById(Long id);

    @Insert("INSERT INTO users (username, email) values (#{username}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
//    Insert 작업에 대한 추가 옵션 설정
//    - useGeneratedKeys = true : 데이터베이스에서 자동 생성되는 키 (auto-increment pk)를 사용하겠다
//    - keyProperty = "id" : 생성된 값을 User 객체의 id 필드에 저장하겠다는 의미
//      -> insert 메서드 호출 후 전달된 User 객체의 id 필드는 데이터베이스에서 생성된 실제 id 값으로 업데이트
//          -> 새로 삽입된 행의 id를 즉시 알 수 있게 되어 이후 작업에 해당 id를 사용 가능
//    만약, users테이블의 id(pk)를 수동으로 설정한다면 Options 어노테이션 필요 x
    void insert(User user);

    @Update("UPDATE users SET username = #{username}, email = #{email} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);

//    case2. XML 기반 매퍼

}