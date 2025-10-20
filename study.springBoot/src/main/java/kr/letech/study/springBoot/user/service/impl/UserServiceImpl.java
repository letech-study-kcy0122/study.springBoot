/**
 * 
 */
package kr.letech.study.springBoot.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public List<UserEntity> readUserList(Integer keyword, String term) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.readUserList() 호출.");
		log.debug("▩ ----- 검색박스 파라미터 확인: keyword={}, term={}", keyword, term);
		
		List<UserEntity> userList = new ArrayList<>();
		
		if("default".equals(term)) {
			log.debug("▩ ----- {\"default\".equals(term)} 분기를 탐.");
			userList = userRepository.findAllByDelYnOrderByRgstDtDesc(DEL_N);
		} else if(keyword == 0) {
			log.debug("▩ ----- {keyword == 0} 분기를 탐.");
			userList = userRepository.findAllByDelYnAndUserIdContainingOrUserNmContaining(DEL_N, term, term);
		} else if(keyword == 1) {
			log.debug("▩ ----- {keyword == 1} 분기를 탐.");
			userList = userRepository.findAllByDelYnAndUserIdContaining(DEL_N, term);
		} else if(keyword == 2) {
			log.debug("▩ ----- {keyword == 2} 분기를 탐.");
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
		//나중에 DTO 계층을 추가하는 게 맞을까? 굳이일까? 비밀번호는 JSON 숨기는게 맞지않나?
		return userRepository.save(entity);
	}
	
	@Override @Transactional
	public UserEntity modifyUser(String userId, UserEntity u, String username) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.modifyUser( user ) 호출.");
		
		//1) 엔터티 가져와서 조회하고
		UserEntity entity = userRepository.findFirstByDelYnAndUserId(DEL_N, userId);
		
		//2) 수정할 값만 바꿔주면
		log.debug("▩ ----- 받아온 entity::: {}", u);
		log.debug("▩ ----- rgstDt::: {}", entity.getRgstDt());
		//---entity.setUserId();
		entity.setUserPw(u.getUserPw());
		entity.setUserNm(u.getUserNm());
		entity.setRegno1(u.getRegno1());
		entity.setRegno2(u.getRegno2());
		//---entity.setRgstId();
		entity.setUpdtId(username);
		entity.setProfileGrpId(u.getProfileGrpId());
		
		//0) 알아서 업데이트 된다.
		return u;
	}
	
	@Override @Transactional
	public UserEntity removeUser(String userId, String username) {
		log.debug("▩▩▩ USER_SERVICE_IMPL.removeUser( ) 호출.");
		
		UserEntity user = userRepository.findById(userId).orElseThrow();
		
		user.setDelYn("Y");
		user.setUpdtId(username);
		user.setUpdtDt(new Date());
		
		userRepository.deleteByUserId(userId, username);
		return user;
	}
}
