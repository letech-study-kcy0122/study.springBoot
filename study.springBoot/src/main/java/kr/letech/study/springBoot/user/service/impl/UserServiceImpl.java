/**
 * 
 */
package kr.letech.study.springBoot.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.user.entity.Users;
import kr.letech.study.springBoot.user.repository.UserRepository;
import kr.letech.study.springBoot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Service @RequiredArgsConstructor @Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Override
	public List<Users> readUserList() {
		log.debug("▩▩▩ USER_SERVICE_IMPL.readUserList() 호출.");
		return userRepository.findAllByDelYn("N");
	}
	
	@Override
	public Users readUser(String userId) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.readUser( userId ) 호출.");
		return userRepository.findFirstByUserIdAndDelYn(userId, "N");
	}


}
