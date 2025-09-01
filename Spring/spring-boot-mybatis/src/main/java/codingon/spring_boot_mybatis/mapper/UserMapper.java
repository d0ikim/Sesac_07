package codingon.spring_boot_mybatis.mapper;

import codingon.spring_boot_mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 해당 인터페이스가 MyBatis의 mapper 임을 나타냄
public interface UserMapper {

//    case1. 어노테이션 기반 매퍼
//    - 간단한 SQL(쿼리)의 경우 간결하게 표현
//    - Java 코드 내에서 SQL 문을 직접 볼 수 있어 즉각적인 이해 가능
//    - @Select, @Insert, @Update, @Delete 어노테이션 사용
    @Select("SELECT * FROM users")
    List<User> findAll();

//    case2. XML 기반 매퍼

}