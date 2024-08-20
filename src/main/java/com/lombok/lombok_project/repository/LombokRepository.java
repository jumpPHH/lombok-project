package com.lombok.lombok_project.repository;

import com.lombok.lombok_project.domain.vo.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// ROOT
// Repository<T, ID>: 기본 인터페이스로, 스프링 데이터 리포지토리의 상위 인터페이스입니다. 이 인터페이스는 아무 메서드도 정의하지 않습니다.
// ↓
//CrudRepository<T, ID>: Repository를 확장한 인터페이스로, 기본적인 CRUD(Create, Read, Update, Delete) 메서드를 제공합니다.
// ↓
//PagingAndSortingRepository<T, ID>: CrudRepository를 확장하며, 페이징과 정렬 기능을 추가로 제공합니다.
// ↓
//JpaRepository<T, ID>: PagingAndSortingRepository를 확장하며, JPA에서 사용하는 다양한 메서드를 추가로 제공합니다.

// JpaRepository<T,ID>: T는 엔티티의 타입, ID는 엔티티의 식별자(Primary Key) 타입을 의미

// CRUD 메서드:
//save(S entity): 엔티티를 저장하거나 업데이트합니다.
//findById(ID id): 특정 ID에 해당하는 엔티티를 반환합니다.
//findAll(): 모든 엔티티를 반환합니다.
//deleteById(ID id): 특정 ID에 해당하는 엔티티를 삭제합니다.
//count(): 엔티티의 총 개수를 반환합니다.

// JpaRepository를 확장하면서도 커스텀 쿼리 메서드를 정의할 수 있습니다.
// 1. **쿼리 메서드(Query Method)**라고 불리며, 메서드 이름을 분석하여 SQL 쿼리를 생성하는 방식을 사용.
// ->  스프링 데이터 JPA가 메서드 이름을 분석하여 자동으로 쿼리를 생성해주는 기능입니다.

// 메서드 이름은 특정한 규칙이 있는데
// findBy: 조건에 맞는 데이터를 조회
// And, Or: 여러 조건을 조합
// GreaterThan, LessThan: 비교 연산자
// OrderBy: 정렬

// 1. @Query 어노테이션을 사용.

// 1-1 쿼리 메서드의 이름 규칙을 사용하지 않거나, 복잡한 쿼리를 작성해야 하는 경우 사용.
// ex)   @Query(value = "SELECT * FROM users WHERE name = :name AND age = :age", nativeQuery = true)
//       List<User> findUsersByNameAndAgeNative(@Param("name") String name, @Param("age") int age);

// 2. 커스텀 리포지토리 구현을 따로 하여 사용가능
//  public interface CustomUserRepository {
//    List<User> findUsersByCustomCriteria();
//  }
//
//  public class CustomUserRepositoryImpl implements CustomUserRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<User> findUsersByCustomCriteria() {
//        // 직접 쿼리 작성
//        String query = "SELECT u FROM User u WHERE ...";
//        return entityManager.createQuery(query, User.class).getResultList();
//      }
//  }
@Repository
public interface LombokRepository extends JpaRepository<Developer, Long> {

}
