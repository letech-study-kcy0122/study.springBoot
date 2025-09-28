/**
 * 
 */
package kr.letech.study.springBoot.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class HelloController {
	
	@GetMapping("/api/v1/hello")
	public ResponseEntity<?> hello() {
		return ResponseEntity.ok("Hello World!!");
	}

}
