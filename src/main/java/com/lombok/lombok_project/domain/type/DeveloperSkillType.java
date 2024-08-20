package com.lombok.lombok_project.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

// @AllArgsConstructor : 모든 인수를 갖는 생성자
@AllArgsConstructor

// @Getter : getter 메서드를 자동으로 생성
@Getter
public enum DeveloperSkillType {

    BACK_END("Back-end Developer"),
    FRONT_END("Front-end Developer"),
    FULL_STACK("Full-stack Developer"),;

    private final String description;
}
