/**
 * 
 */
package kr.letech.study.springBoot.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.user.entity.Users;
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
@RestController @RequiredArgsConstructor @Slf4j
public class RESTUserController {
	
	private final UserService userService;
	
	public List<Users> userDetail(
			
			) {
		log.debug("▩▩▩▩▩ REST_API:: USER_CONTROLLER.userDetail() 연결.");
		
		return userService.readUserList();
	}

}
