/**
 * 
 */
package kr.letech.study.springBoot.cmmn.role.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.cmmn.role.entity.UserRoleEntity;
import kr.letech.study.springBoot.cmmn.role.entity.UserRoleId;

/**
 * 
 * <pre>
 * 
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-09-29		KCY				최초 생성
 *  2025-09-30		KCY				MERGE문 작업
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, UserRoleId>{

	//0929_wtf
	//복합키 id값을 embedded했을 경우 속성 경로 파싱할 때 모호하다고 한다.
	//그래서 entity의 복합키 프로퍼티 명은 id로 표준을 따라가고, Id_<컬럼명프로퍼티>로 수동 경계 지정을 한다. 
	public List<UserRoleEntity> findAllByDelYnAndId_UserIdContaining(String delYn, String userId);
	
	//0930_insert/update/delete 하나로 묶는 merge
	@Modifying
	@Query(" UPDATE UserRoleEntity ur "
			+ " SET ur.delYn = 'Y', ur.updtId = :username, ur.updtDt = CURRENT_TIMESTAMP "
			+ " WHERE ur.id.userId = :userId "
			+ " AND ur.id.userRole NOT IN :activeRoles ")
	public void softDeleteNotInRoles(@Param("userId") String userId
			, @Param("activeRoles") List<String> activeRoles
			, @Param("username") String username);

	
	
	//0930_사용자 권한 추가/수정 단계에서 검증에 필요한 메소드
	public Boolean existsByDelYnAndId_UserIdAndId_userRole(String delYn, String userId, String userRole);
	public List<UserRoleEntity> findByDelYnAndId_UserId(String userId, String delYn);
	public Optional<UserRoleEntity> findByDelYnAndId_UserIdAndId_UserRole(String delYn, String userId, String userRole);
}
