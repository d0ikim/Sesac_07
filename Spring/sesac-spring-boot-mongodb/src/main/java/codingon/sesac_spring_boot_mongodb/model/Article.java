package codingon.sesac_spring_boot_mongodb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document   // MongoDB Collection과 매핑 (JPA @Entity와 유사한 기능)
@Data       // getter, setter, toString, equals, hashCode 등 자동 생성 (Lombok)
@Builder    // 빌더 패턴 지원
public class Article {
    @Id // MongoDB의 _id 필드로 사용되며, String타입으로 선언하면 자동으로 ObjectId가 문자열로 변환됨 (JPA의 @Id와 동일한 역할)
    private String id;

    private String name;

    private String email;

    @TextIndexed(weight = 2)    // 텍스트 검색 인덱스 생성, 가중치 2
//    가중치? 가중치가 높을수록 검색 결과에서 더 중요한 필드로 취급
//    제목이 내용보다 중요하므로 가중치를 2로 설정
    private String title;

    @TextIndexed    // 텍스트 검색 인덱스 생성, 가중치 1(기본값)
//    제목보다는 덜 중요하지만 검색대상에 포함
    private String description;

    @TextScore  // MongoDB가 텍스트 검색 시 자동으로 계산하는 점수
//    검색어와의 관련성을 나타내는 수치 (높을수록 관련성 높음)
//    실제 데이터베이스에는 저장되지 않고, 검색 시에만 계산됨
//    검색 결과 정렬이나 필터링 할 때 활용 가능
    private String score;
}