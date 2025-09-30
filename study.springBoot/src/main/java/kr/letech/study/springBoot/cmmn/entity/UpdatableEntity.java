/**
 * 
 */
package kr.letech.study.springBoot.cmmn.entity;

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
 *  2025-09-30		KCY				최초 생성
 */
public interface UpdatableEntity {

	//0930_엔터티 내부에서 공통속성 갱신
	public void update(String username);
	public void insert(String username);
	
	//0930_중복 판별용 KEY (ex: userId + userRole 처럼 복합키의 결합)
	public String getBusinessKey();
}
