package codingon.spring_boot_jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// 실제 데이터의 역할 (테이블 구조와 동일해야 함)
@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

//    @Column()
    private String writer;

    @Column(name = "registered", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String registered;

    @PrePersist
    protected void onRegister() {
        registered = String.valueOf(LocalDateTime.now());
    }
}
