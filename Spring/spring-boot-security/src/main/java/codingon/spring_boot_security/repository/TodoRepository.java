package codingon.spring_boot_security.repository;

import codingon.spring_boot_security.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {   // JpaRepository에서 기본 메서드규칙을 지켜 네이밍하면 알아서 이미 다 갖고있는 SQL쿼리들을 날려준다 개이득!!
    List<TodoEntity> findByUserId(String userId);
}