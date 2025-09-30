/**
 * 
 */
package kr.letech.study.springBoot.cmmn.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.cmmn.code.entity.CommonCodeEntity;

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
 */
@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCodeEntity, String>{
	
	public List<CommonCodeEntity> findAllByDelYnAndCmmnGrpCdContaining(String delYn, String cmmnGrpId);
}
