/**
 * 
 */
package kr.letech.study.springBoot.cmmn.files.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.cmmn.files.entity.FilesEntity;
import kr.letech.study.springBoot.cmmn.files.service.FileService;
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
 *  2025-10-01		KCY				최초 생성
 */
@RestController @RequiredArgsConstructor @Slf4j
@RequestMapping("/file-management/files")
public class RESTFileController {
	
	private final FileService fileService;
	
	@RequestMapping(value = "/ref-nm/{fileGrpId}", method = RequestMethod.GET)
	public ResponseEntity<Envelope<List<String>>> getProfileSrc(
			@PathVariable("fileGrpId") String fileGrpId
			) {
		log.debug("▩▩▩▩▩ REST_API:: FILE_CONTROLLER.getProfileSrc() 연결.");
		
		List<String> fileRefNmList = fileService.readFileRefNmList(fileGrpId);
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, fileRefNmList));
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Envelope<FilesEntity>> postFile(
			@RequestParam("username") String username
			, @RequestBody FilesEntity vo
			) {
		log.debug("▩▩▩▩▩ REST_API:: FILE_CONTROLLER.postFile() 연결.");
		
		
		FilesEntity fileEntity = fileService.createFile(vo, username);
		String cid = UUID.randomUUID().toString();
		
		return ResponseEntity.ok(Envelope.ok(cid, fileEntity));
	}
	
}
