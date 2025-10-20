/**
 * 
 */
package kr.letech.study.springBoot.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.user.entity.UserEntity;


/**
 * 
 * <pre>
 * 	상속받는 JpaRepository<ENTITY, PK_TYPE>의 첫번째에는
 *  이 녀석이 다룰 Entity 객체 클래스를,
 *  두 번째에는 해당 Entity의 PK 타입을 넣어줘야 한다.
 *  그리고 PK 프로퍼티에 @ID 어노테이션 붙인다.
 *  
 *  복합키를 쓸 경우에는 다른 방식을 가져와야 한다.
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-09-26		KCY				최초 생성
 *  2025-09-29		KCY				8080서버 서비스에서 각각 호출하도록
 *  								REST API 분기
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	//0929_8080서버 서비스에서 각각 호출하도록 REST API 분기
	//UserList
	public List<UserEntity> findAllByDelYnOrderByRgstDtDesc(String delYn);
	public List<UserEntity> findAllByDelYnAndUserIdContaining(String delYn, String userId);
	public List<UserEntity> findAllByDelYnAndUserNmContaining(String delYn, String userNm);
	public List<UserEntity> findAllByDelYnAndUserIdContainingOrUserNmContaining(String delYn, String userId, String userNm);
	
	//UserDetail
	public UserEntity findFirstByDelYnAndUserId(String delYn, String userId);
	
	//UserDelete
	@Modifying
	@Query("UPDATE UserEntity u " +
	       "SET u.delYn = 'Y', u.updtId = :username, u.updtDt = CURRENT_TIMESTAMP " +
	       "WHERE u.userId = :userId")
	public void deleteByUserId(@Param("userId") String userId, @Param("username") String username);
	
}
