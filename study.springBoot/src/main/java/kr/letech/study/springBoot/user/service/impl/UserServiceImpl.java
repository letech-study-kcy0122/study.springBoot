/**
 * 
 */
package kr.letech.study.springBoot.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.user.entity.UserEntity;
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
 *  2025-09-29		KCY				최초 작업
 */
@Service @RequiredArgsConstructor @Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final String DEL_N = "N";
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public List<UserEntity> readUserList(Integer keyword, String term) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.readUserList() 호출.");
		log.debug("▩ ----- 검색박스 파라미터 확인: keyword={}, term={}", keyword, term);
		
		List<UserEntity> userList = new ArrayList<>();
		
		if("default".equals(term)) {
			userList = userRepository.findAllByDelYn(DEL_N);
		} else if(keyword == 0) {
			userList = userRepository.findAllByDelYnAndUserIdContainingOrUserNmContaining(DEL_N, term, term);
		} else if(keyword == 1) {
			userList = userRepository.findAllByDelYnAndUserIdContaining(DEL_N, term);
		} else if(keyword == 2) {
			userList = userRepository.findAllByDelYnAndUserNmContaining(DEL_N, term);
		}
		
		log.debug("▩ ----- 반환값[userList] : {}", userList);
		return userList;
	}
	
	@Override
	public UserEntity readUser(String userId) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.readUser( userId ) 호출.");
		return userRepository.findFirstByDelYnAndUserId(DEL_N, userId);
	}

	@Override
	public UserEntity createUser(UserEntity u) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.createUser( user ) 호출.");
		UserEntity entity = new UserEntity();
		log.debug("▩ ----- 받아온 entity::: {}", u);
		entity.setUserId(u.getUserId());
		entity.setUserPw(u.getUserPw());
		entity.setUserNm(u.getUserNm());
		entity.setRegno1(u.getRegno1());
		entity.setRegno2(u.getRegno2());
		entity.setRgstId(u.getUserId());
		entity.setUpdtId(u.getUserId());
		entity.setProfileGrpId(u.getProfileGrpId());
		//rgstDt, updtDt는 어노테이션으로 해결.
		//delYn은 기본값 "N" 입력됨.
		return userRepository.save(entity);
	}
	
	@Override

	public UserEntity modifyUser(UserEntity user) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.modifyUser( user ) 호출.");
		
		//1) 엔터티 가져와서 조회하고
		
		//2) 수정할 값만 바꿔주면
		
		//0) 알아서 업데이트 된다.
	}
}
