package com.lombok.lombok_project.domain.vo;

import com.lombok.lombok_project.domain.type.DeveloperLevel;
import com.lombok.lombok_project.domain.type.DeveloperSkillType;
import com.lombok.lombok_project.domain.type.StatusCode;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


//################################################################ Lombok Anotation

// @Getter : getter 메서드를 자동으로 생성
@Getter
// @Setter : setter 메서드를 자동으로 생성
@Setter

// @AllArgsConstructor : 모든 인수를 갖는 생성자
@AllArgsConstructor

// @NoArgsConstructor : 인수가 없는 생성자
@NoArgsConstructor

// @Builder : 모든 필드를 인수로 사용하여 패키지 전용 빌더 패턴사용 가능
@Builder

@ToString
//################################################################ JPA(Java Persistence API) Anotation

// @Entity : 데이터베이스 테이블과 자바 클래스 간의 매핑

// 1. @Id 지정 필수

// 2. @GeneratedValue Anotation을 사용 하여, 기본 키값을 자동 생성 <- 선택하여 사용. 사용안해도됨
// 옵션으로 다양한 생성 전략이 있다.
// [ IDENTITY, SEQUENCE, TABLE, AUTO ]
@Entity
@EntityListeners(AuditingEntityListener.class)
// @Table : 해당 클래스와 매핑할 테이블의 이름 지정.
@Table(name = "developers")
public class Developer {

    // @Id : 테이블의 기본 키(Primary Key)
    @Id
    // @GeneratedValue : 기본 키의 값을 자동으로 생성
    // strategy = 생성 전략 [ IDENTITY, SEQUENCE, TABLE, AUTO ]
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String memberId;
    private String email;
    private int age;
    private int experienceYears;

    //@Enumerated : enum 타입의 필드가 데이터베이스에 저장될 때, 이를 문자열로 저장할지 또는 숫자로 저장할지를 결정합니다.

    // EnumType.STRING: enum의 이름을 문자열로 저장합니다.
    // 예를 들어, enum 타입이 SPRING, SUMMER, FALL, WINTER로 정의되어 있으면,
    // 데이터베이스에 SPRING, SUMMER 등으로 저장됩니다.

    // EnumType.ORDINAL: enum의 순서를 숫자로 저장합니다.
    // 예를 들어, SPRING은 0, SUMMER는 1, FALL은 2, WINTER는 3으로 저장됩니다.
    // 이때 주의할 점은, enum의 순서가 변경되거나 새로운 값이 추가되면 데이터베이스에 저장된 값이 잘못 해석될 수 있다는 것입니다
    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;

    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;

    //@CreateDate : 생성 시각을 자동으로 기록하기 위해 사용
    @CreatedDate
    private LocalDateTime createdAt;

    // @LastModifiedDate : 수정 시각을 자동으로 기록하기 위해 사용
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
