/**
 * 
 */
package kr.letech.study.springBoot.user.service;

import java.util.List;

import kr.letech.study.springBoot.user.entity.Users;

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
 */
public interface UserService {
	public List<Users> readUserList();
	public Users readUser(String userId);
}
