/**
 * 
 */
package kr.letech.study.springBoot.cmmn.files.service;

import java.util.List;

import kr.letech.study.springBoot.cmmn.files.entity.FilesEntity;

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
public interface FileService {
	
	public List<String> readFileRefNmList(String fileGrpId);
	public FilesEntity createFile(FilesEntity fileEntity, String username);
}
