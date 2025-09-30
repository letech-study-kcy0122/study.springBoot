/**
 * 
 */
package kr.letech.study.springBoot.cmmn.code.service;

import java.util.List;

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
public interface CommonCodeService {
	public List<CommonCodeEntity> readCommonCodeList(String cmmnGrpCd);
}
