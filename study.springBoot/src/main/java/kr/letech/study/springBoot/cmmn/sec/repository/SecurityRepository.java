/**
 * 
 */
package kr.letech.study.springBoot.cmmn.sec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.user.entity.UserEntity;

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
 *  2025-10-16		KCY				최초 생성
 */
@Repository
public interface SecurityRepository extends JpaRepository<UserEntity, String>{
}
