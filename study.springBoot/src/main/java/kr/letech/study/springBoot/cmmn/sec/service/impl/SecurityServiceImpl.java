/**
 * 
 */
package kr.letech.study.springBoot.cmmn.sec.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.cmmn.sec.service.SecurityService;
import kr.letech.study.springBoot.user.entity.UserEntity;
import kr.letech.study.springBoot.user.repository.UserRepository;
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
 *  2025-10-16		KCY				최초 생성
 */
@Service @RequiredArgsConstructor @Slf4j
public class SecurityServiceImpl implements SecurityService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final String DEL_N = "N";
	
	@Override
	public Map<String, Object> checkCurrentPassword(Map<String, String> params, String username) {
		log.debug("▩▩▩ SECURITY_SERVICE_IMPL.checkCurrentPassword() 호출.");
		
		String userId = params.get("userId");
		String unvalidPw = params.get("password");
		
		UserEntity entity = userRepository.findFirstByDelYnAndUserId(DEL_N, userId);
		String currentPw = entity.getUserPw();
		
		Boolean isValid = passwordEncoder.matches(unvalidPw, currentPw);
		String msg = "비밀번호 2차 인증에 실패했습니다.\n다시 확인해주세요.";
		
		if(isValid) {
			msg = "비밀번호 2차 인증 성공!!! ^0^";
		}
		
				
		log.debug("▩ ----- userId: {} ", userId);
		log.debug("▩ ----- unvalidPw: {} ", unvalidPw);
		log.debug("▩ ----- currentPw: {} ", currentPw);
		log.debug("▩ ----- isValid: {}", isValid);
		log.debug("▩ ----- msg: {} ", msg);
		
		Map<String, Object> result = new HashMap<>();
		result.put("isValid", isValid);
		result.put("msg", msg);
		
		return result;
	}
}
