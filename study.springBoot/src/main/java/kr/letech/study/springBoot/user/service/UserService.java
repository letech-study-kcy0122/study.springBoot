/**
 * 
 */
package kr.letech.study.springBoot.user.service;

import java.util.List;

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
 *  2025-09-26		KCY				최초 생성
 *  2025-09-29		KCY				최초 작업
 */
public interface UserService {
	public List<UserEntity> readUserList(Integer keyword, String term);
	public UserEntity readUser(String userId);
	
	public UserEntity createUser(UserEntity user);
	public UserEntity modifyUser(String userId, UserEntity user, String username);
	public UserEntity removeUser(String userId, String username);
}
