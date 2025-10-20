/**
 * 
 */
package kr.letech.study.springBoot.cmmn.sec.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.cmmn.restTemplate.envelope.Envelope;
import kr.letech.study.springBoot.cmmn.sec.service.SecurityService;
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
 *  2025-10-16		KCY				비밀번호 2차인증 기능 구현
 */
@RestController @RequiredArgsConstructor @Slf4j
@RequestMapping("/sec-management")
public class RESTSecurityController {
	
	private final SecurityService securityService;


	/**
	 * 비밀번호 2차인증용 컨트롤러
	 * params 안에는 입력된 비밀번호 하나와, 수정하려는 회원의 userId가 들어있다.
	 * 
	 * @param params {password, userId}
	 * @return
	 */
	@RequestMapping(value="/users/pw-check", method=RequestMethod.POST)
	public ResponseEntity<Envelope<Map<String,Object>>> checkCurrentPassword(
			@RequestBody Map<String, String> params
			, @RequestParam(name="username", required=false) String username 
			) {
		log.debug("▩▩▩▩▩ REST_API:: SECURITY_CONTROLLER.getUserList() 연결.");
		
		Map<String, Object> result = securityService.checkCurrentPassword(params, username);
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, result));
	}
}
