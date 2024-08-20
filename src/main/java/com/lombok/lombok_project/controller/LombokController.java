package com.lombok.lombok_project.controller;

import com.lombok.lombok_project.domain.vo.Developer;
import com.lombok.lombok_project.service.LombokService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController

// @RequiredArgsConstructor : 클래스 내에서 final로 선언된 필드와 @NonNull 어노테이션이 적용된 필드에 대해 생성자를 자동으로 생성
// 이 어노테이션은 특히 의존성 주입(Dependency Injection)을 사용하는 스프링 프로젝트에서 유용하게 사용
// ->
//     public LombokController(LombokService lombokService) {
//        this.lombokService = lombokService;
//    }
@RequiredArgsConstructor
public class LombokController {

    private final LombokService lombokService;

    @GetMapping("/create/developer")
    public Developer CreateDeveloperRepository(){

        return lombokService.createDeveloperRepository();
    }
}
