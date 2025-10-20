/**
 * 
 */
package kr.letech.study.springBoot.user.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.cmmn.restTemplate.envelope.Envelope;
import kr.letech.study.springBoot.user.entity.UserEntity;
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
 *  2025-10-16		KCY				비밀번호 2차인증 컨트롤러 구현
 */
@RestController @RequiredArgsConstructor @Slf4j
@RequestMapping("/user-management/users")
public class RESTUserController {
	
	private final UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Envelope<List<UserEntity>>> getUserList(
			@RequestParam(name = "keyword", required=false, defaultValue="0") Integer keyword
			, @RequestParam(name = "term", required=false, defaultValue="default") String term
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.getUserList() 연결.");
		log.debug("▩ SEARCH-BOX: KEYWORD = \"{}\", TERM = \"{}\"", keyword, term);
		
		List<UserEntity> voList = userService.readUserList(keyword, term);
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, voList));
	}

	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Envelope<UserEntity>> getUser(
			@PathVariable(name = "userId") String userId
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.getUser() 연결.");
		
		UserEntity entity = userService.readUser(userId);
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, entity));
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Envelope<UserEntity>> postUser(
			@RequestBody UserEntity user
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.postUser() 연결.");
		
		UserEntity entity = userService.createUser(user);
		String cid = UUID.randomUUID().toString();
		return ResponseEntity.ok(Envelope.ok(cid, entity));
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<Envelope<UserEntity>> putUser(
			@PathVariable("userId") String userId
			, @RequestBody UserEntity user
			, @RequestParam("username") String username
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.putUser() 연결.");
		
		UserEntity entity = userService.modifyUser(userId, user, username);
		String cid = UUID.randomUUID().toString();
		return ResponseEntity.ok(Envelope.ok(cid, entity));
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Envelope<UserEntity>> deleteUser(
			@PathVariable("userId") String userId
			, @RequestParam(name="username", required=false) String username
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.deleteUser() 연결.");
		
		UserEntity entity = userService.removeUser(userId, username);
		String cid = UUID.randomUUID().toString();
		return ResponseEntity.ok(Envelope.ok(cid, entity));
	}
}
