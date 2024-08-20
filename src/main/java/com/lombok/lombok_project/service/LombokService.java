package com.lombok.lombok_project.service;

import com.lombok.lombok_project.domain.vo.Developer;
import com.lombok.lombok_project.repository.LombokRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.lombok.lombok_project.domain.type.DeveloperLevel.JUNIOR;
import static com.lombok.lombok_project.domain.type.DeveloperSkillType.BACK_END;
import static com.lombok.lombok_project.domain.type.StatusCode.WORKING;

// @Slf4j : log 처리를 할때 사용하는 lombok anotation
// private static final Logger log = org.slf4j.LoggerFactory.getLogger(LombokService.class);
// -> 클래스에 자동으로 로거(Logger) 인스턴스를 생성
// log.info(), log.debug(), log.error() 등을 사용하여 다양한 레벨의 로그를 출력
@Slf4j

@Service
// @RequiredArgsConstructor : 클래스 내에서 final로 선언된 필드와 @NonNull 어노테이션이 적용된 필드에 대해 생성자를 자동으로 생성
// 이 어노테이션은 특히 의존성 주입(Dependency Injection)을 사용하는 스프링 프로젝트에서 유용하게 사용
// ->
//     public LombokService(LombokRepository repository) {
//        this.repository = repository;
//    }
@RequiredArgsConstructor
public class LombokService {

    private final LombokRepository repository;

    // @Transactional : 이 메서드가 호출할 때 어노테이션을 시작하고 commit/rollback할지 결정
    @Transactional
    public Developer createDeveloperRepository(){

        // @Builder : 모든 필드를 인수로 사용하여 패키지 전용 빌더 패턴사용 가능
        // [ ObjectName ].builder().build();
        Developer developer = Developer.builder()
                .name("Lombok")
                .memberId("developer0001")
                .email("lombok@example.com")
                .age(30)
                .experienceYears(3)
                .developerLevel(JUNIOR)
                .developerSkillType(BACK_END)
                .statusCode(WORKING)
                .build();

        log.info("Created Developer Info: {}" , developer.toString());

        return repository.save(developer);
    }
}
