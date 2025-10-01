/**
 * 
 */
package kr.letech.study.springBoot.cmmn.files.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.cmmn.files.entity.FilesEntity;
import kr.letech.study.springBoot.cmmn.files.repository.FileRepository;
import kr.letech.study.springBoot.cmmn.files.service.FileService;
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
@Service @RequiredArgsConstructor @Slf4j
public class FileServiceImpl implements FileService {
	
	private final FileRepository fileRepository;
	private final String DEL_N = "N";

	@Override
	public List<String> readFileRefNmList(String fileGrpId) {
		log.debug("▩▩▩ FILE_SERVICE_IMPL.readFileRefNmList() 호출.");
		List<FilesEntity> entityList = fileRepository.findAllByDelYnAndId_FileGrpIdOrderById_FileSeq(DEL_N, fileGrpId);
		List<String> fileRefNmList = new ArrayList<>();
		for(int i=0; i<entityList.size(); i++) {
			fileRefNmList.add(entityList.get(i).getFileRefNm());
		}
		return fileRefNmList;
	}

	@Override
	public FilesEntity createFile(FilesEntity vo, String username) {
		log.debug("▩▩▩ FILE_SERVICE_IMPL.readFileRefNmList() 호출.");
		FilesEntity entity = new FilesEntity();
		entity.setFileOrgNm(vo.getFileOrgNm());
		entity.setFileRefNm(vo.getFileRefNm());
		entity.setFileSize(vo.getFileSize());
		entity.setFileDir(vo.getFileDir());
		entity.setAttachType(vo.getAttachType());
		entity.setMimeType(vo.getMimeType());
		entity.setLastModified(vo.getLastModified());
		entity.insert(username);
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	

}
