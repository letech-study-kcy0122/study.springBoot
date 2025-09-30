/**
 * 
 */
package kr.letech.study.springBoot.cmmn.code.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.cmmn.code.entity.CommonCodeEntity;
import kr.letech.study.springBoot.cmmn.code.service.CommonCodeService;
import kr.letech.study.springBoot.cmmn.restTemplate.envelope.Envelope;
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
@RestController @RequiredArgsConstructor @Slf4j
@RequestMapping("/cmmn-management/code")
public class RESTCommonCodeController {

	public final CommonCodeService commonCodeService;
	
	@RequestMapping(value = "/{cmmnGrpCd}", method = RequestMethod.GET)
	public ResponseEntity<Envelope<List<CommonCodeEntity>>> getCmmnCodeList(
			@PathVariable("cmmnGrpCd") String cmmnGrpCd) {
		log.debug("▩▩▩▩▩ REST_API:: CMMN_CODE_CONTROLLER.getCmmnCodeList() 연결.");
		
		List<CommonCodeEntity> voList = commonCodeService.readCommonCodeList(cmmnGrpCd);
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, voList));
	}
}
