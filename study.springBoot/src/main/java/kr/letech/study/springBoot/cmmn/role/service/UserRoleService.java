/**
 * 
 */
package kr.letech.study.springBoot.cmmn.role.service;

import java.util.List;

import kr.letech.study.springBoot.cmmn.role.entity.UserRoleEntity;

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
public interface UserRoleService{
	
	public List<UserRoleEntity> readRolesOfUser(String userId);
	
	public void saveOrUpdate(String userId, List<String> userRoles, String username);
	public void insert(String userId, String userRole, String username);
	public void update(String userId, String userRole, String username);
	public void mergeUserRoles(String userId, List<String> userRoles, String username);
}
