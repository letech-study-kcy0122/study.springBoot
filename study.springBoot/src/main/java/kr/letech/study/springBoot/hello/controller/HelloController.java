/**
 * 
 */
package kr.letech.study.springBoot.hello.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.cmmn.restTemplate.envelope.Envelope;

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
	
	@RequestMapping(value = "/cmmn-management/root", method = RequestMethod.GET)
	public ResponseEntity<Envelope<String>> home() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String serverTime = sdf.format(date);
		
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, serverTime));
	}

}
