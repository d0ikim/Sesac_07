package codingon.sesac_spring_boot_mongodb.service;

import codingon.sesac_spring_boot_mongodb.model.Article;
import codingon.sesac_spring_boot_mongodb.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

//    =================== 기본 CRUD 메서드 ===================
//    새로운 Article 생성
//    Repository.save(): MongoDB에 문서 저장
//    -> MongoDB가 자동으로 ObjectId 생성
    public Article createArticle(Article article) {
        log.info("Creating article: {}", article);
        return articleRepository.save(article);
    }

//  ID로 Article 조회
    public Article getArticleById(String id) {
        log.info("Getting article by id: {}", id);
        return articleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Article not found with id: "+id));  // null값이 들어올 수 있는 데이터이기 때문에, 결과가 없다면 람다표현식을 이용해 예외처리
    }

//    모든 Article 조회 (페이징 없음)
//    - 성능 주의: 대용량 데이터에서는 메모리 부족할 가능성이 있음
//    - 페이징 처리하는 것이 권장됨
    public List<Article> getAllArticles() {
        log.info("Getting all articles.");
        return articleRepository.findAll();
    }
    
//    모든 Article 조회 (페이징 적용)
    public Page<Article> getAllArticles(Pageable pageable) {
        log.info("Getting all articles with pagination: {}", pageable);
        return articleRepository.findAll(pageable);
    }
    
//    Article 수정
    public Article updateArticle(String id, Article article) {
        log.info("Updating article with id: {}, data: {}", id, article);
        Article existingArticle = getArticleById(id);   // 기존 데이터 조회 (예외 처리 포함되어 있음)
        
//        각 필드별 업데이트
        existingArticle.setName(article.getName());
        existingArticle.setEmail(article.getEmail());
        existingArticle.setTitle(article.getTitle());
        existingArticle.setDescription(article.getDescription());
        
        return articleRepository.save(existingArticle); // 수정된 데이터 저장
    }

//    Article 삭제
    public void deleteArticle(String id) {
        log.info("Deleting article with id: {}", id);

        Article article = getArticleById(id);   // 기존 데이터 조회 (예외 처리 포함되어 있음)
        articleRepository.delete(article);  // 데이터 삭제
    }


//    =================== 검색 관련 메서드 ===================



//    =================== 필드별 검색 메서드 ===================
//    이름으로 정확한 매칭 검색
    public List<Article> findByName(String name) {
        log.info("Finding articles by name: {}", name);
        return articleRepository.findByName(name);
    }

//    이름과 이메일로 AND 조건 검색
    public List<Article> findByNameAndEmail(String name, String email) {
        log.info("Finding articles by name: {} and email: {}", name, email);
        return articleRepository.findByNameAndEmail(name, email);
    }

//    이름 또는 이메일로 OR 조건 검색
    public List<Article> findByNameOrEmail(String name, String email) {
        log.info("Finding articles by name: {} or email: {}", name, email);
        return articleRepository.findByNameOrEmail(name, email);
    }

//    이름이 특정 문자열로 시작하는 문서 검색
    public List<Article> findByNameStartingWith(String name) {
        log.info("Finding articles by name starting with: {}", name);
        return articleRepository.findByNameStartingWith(name);
    }

//    이름이 특정 문자열로 끝나는 문서 검색
    public List<Article> findByNameEndingWith(String name) {
        log.info("Finding articles by name ending with: {}", name);
        return articleRepository.findByNameEndingWith(name);
    }

//    이름에 특정 문자열이 포함된 문서 검색
    public List<Article> findByNameContaining(String name) {
        log.info("Finding articles by name containing: {}", name);
        return articleRepository.findByNameContaining(name);
    }

//    이름이 LIKE 패턴과 일치하는 문서 검색
    public List<Article> findByNameLike(String name) {
        log.info("Finding articles by name like: {}", name);
        return articleRepository.findByNameLike(name);
    }


//    =================== 업데이트 메서드 ===================
//    이름으로 이메일 일괄 업데이트
    public int updateEmailByName(String name, String email) {
        log.info("Updating email for name: {} to {}", name, email);
        return articleRepository.updateEmailByName(name, email);
    }
}