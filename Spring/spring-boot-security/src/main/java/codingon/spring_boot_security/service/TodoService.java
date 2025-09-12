package codingon.spring_boot_security.service;

import codingon.spring_boot_security.entity.TodoEntity;
import codingon.spring_boot_security.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
// Simple logging facade for java
// - 로그 라이브러리
// - info, debug, warn, error 로 용도에 따라 나눠서 로깅
// - 로깅하고 싶은 클래스에 해당 어노테이션을 붙이면 됨
@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

//    1. Create todo
    public List<TodoEntity> create(final TodoEntity entity) {
        validate(entity);   // 유효성 검사
        
        repository.save(entity);    // db insert (JPA기본)
        
        log.info("Entity id: {} is saved", entity.getId()); // 로그 찍기

        return repository.findByUserId(entity.getUserId()); // db select 수행 (추가한 그 행을 바로 다시 보여주기)
    }

//    todo: 이거 나중에 보충해야 함
//    fixme: 지금은 하드코딩했는데, 카테고리가 추가되면 코드 변경 필요

//    2. Read todo
    public List<TodoEntity> retrieve(final String userId) {
        return repository.findByUserId(userId);
    }

//    3. Update todo
    public List<TodoEntity> update(final TodoEntity entity) {
        validate(entity);   // 유효성 검사

        repository.save(entity);    // db update (JPA 기본)

        log.info("Entity id: {} is updated", entity.getId());   // 로그 찍기

        return repository.findByUserId(entity.getUserId()); // db select 수행 (수정한 그 행을 포함한 해당 유저의 투두 전체 반환)
    }

//    4. Delete todo
    public void delete(final Long id) {
        repository.deleteById(id);
    }


//    유효성 검사
    private void validate(final TodoEntity entity) {
        if (entity == null) {
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }

        if (entity.getUserId() == null) {
            log.warn("Unknown user");
            throw new RuntimeException("Unknown user");
        }
    }
}