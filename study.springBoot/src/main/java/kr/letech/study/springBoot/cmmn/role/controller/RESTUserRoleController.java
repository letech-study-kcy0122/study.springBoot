/**
 * 
 */
package kr.letech.study.springBoot.cmmn.role.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.letech.study.springBoot.cmmn.restTemplate.envelope.Envelope;
import kr.letech.study.springBoot.cmmn.role.entity.UserRoleEntity;
import kr.letech.study.springBoot.cmmn.role.service.UserRoleService;
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
 *  2025-09-29		KCY				최초 생성
 */
@Controller @RequiredArgsConstructor @Slf4j
@RequestMapping("/cmmn-management/user-role")
public class RESTUserRoleController {
	
	private final UserRoleService userRoleService;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public ResponseEntity<Envelope<List<UserRoleEntity>>> getUserRoles(
			@PathVariable("userId") String userId
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.getUser() 연결.");
		
		List<UserRoleEntity> userRoles = userRoleService.readRolesOfUser(userId);
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, userRoles));
	}

	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public ResponseEntity<Envelope<Void>> mergeUserRoles(
			@PathVariable String userId
			, @RequestBody List<String> userRoles
			, @RequestParam String username
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.mergeUserRoles() 연결.");
		
		String cid = UUID.randomUUID().toString();
//		userRoleService.saveOrUpdate(userId, userRoles, username);
		userRoleService.mergeUserRoles(userId, userRoles, username);
		return ResponseEntity.ok(Envelope.ok(cid, null));
	}
	
}
