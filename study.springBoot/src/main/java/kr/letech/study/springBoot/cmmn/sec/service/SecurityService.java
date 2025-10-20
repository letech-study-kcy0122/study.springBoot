/**
 * 
 */
package kr.letech.study.springBoot.cmmn.sec.service;

import java.util.Map;

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
public interface SecurityService {

	public Map<String, Object> checkCurrentPassword(Map<String, String> params, String username);
}
