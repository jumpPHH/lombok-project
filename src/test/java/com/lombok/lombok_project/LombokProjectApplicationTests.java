package com.lombok.lombok_project;

import com.lombok.lombok_project.domain.type.DeveloperLevel;
import com.lombok.lombok_project.domain.type.DeveloperSkillType;
import com.lombok.lombok_project.domain.type.StatusCode;
import com.lombok.lombok_project.domain.vo.Developer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.lombok.lombok_project.domain.type.DeveloperLevel.JUNIOR;
import static com.lombok.lombok_project.domain.type.DeveloperSkillType.BACK_END;
import static com.lombok.lombok_project.domain.type.StatusCode.WORKING;

class LombokProjectApplicationTests {

	@Test
	void setterTest() { // @Setter
		Developer developer = new Developer();

		developer.setName("test");
		developer.setMemberId("test001");
		developer.setEmail("test@example.com");
		developer.setAge(30);
		developer.setExperienceYears(3);

		developer.setDeveloperLevel(DeveloperLevel.JUNIOR);
		developer.setDeveloperSkillType(DeveloperSkillType.BACK_END);
		developer.setStatusCode(StatusCode.WORKING);

		System.out.println(developer);
	}

	@Test
	void getterTest() { // @Getter
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

		System.out.println( developer.getName()+"\n"+
							developer.getMemberId()+"\n"+
				    		developer.getEmail()+"\n"+
				            developer.getAge()+"\n"+
							developer.getExperienceYears()+"\n"+

				developer.getDeveloperLevel()+"\n"+
				developer.getDeveloperSkillType()+"\n"+
				developer.getStatusCode());
	}

	@Test
	void builderTest() { // @Builder
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

		System.out.println(developer);
	}

	@Test
	void toStringTest() { // @ToString
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

		System.out.println(developer.toString());
	}

	@Test
	void allArgsConstructorTest(){ // @AllArgsConstructor
		LocalDateTime createdAt = LocalDateTime.now();
		LocalDateTime updatedAt = LocalDateTime.now();

		Developer developer = new Developer(1L,"Lombok", "developer0001", "lombok@example.com", 30, 3, JUNIOR, BACK_END, WORKING , createdAt , updatedAt);

        System.out.println(developer);
	}

	@Test
	void noArgsConstructorTest() { // @NoArgsConstructor
		Developer developer = new Developer();

        System.out.println(developer);
	}

}
