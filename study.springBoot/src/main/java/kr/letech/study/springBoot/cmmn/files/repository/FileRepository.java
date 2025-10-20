/**
 * 
 */
package kr.letech.study.springBoot.cmmn.files.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.cmmn.files.entity.FilesEntity;
import kr.letech.study.springBoot.cmmn.files.entity.FilesId;

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
@Repository
public interface FileRepository extends JpaRepository<FilesEntity, FilesId>{

	public List<FilesEntity> findAllByDelYnAndId_FileGrpIdOrderById_FileSeq(String delYn, String fileGrpId);
	public FilesEntity findFirstByDelYnAndId_FileGrpIdAndId_FileSeq(String delYn, String fileGrpId, Integer fileSeq);
//	public List<String> findFileRefNmByDelYnAndId_FileGrpIdOrderById_FileSeq(String delYn, String FileGrpId);
//	사용 불가한 메소드. JPA가 한 컬럼만이 아니라 Entity 전체를 가져오고 있음. 직접 쿼리를 짜든가 해야함.
	
	@Modifying
	@Query(" UPDATE FilesEntity f "
		 + " SET f.delYn = 'Y', f.updtId = :username, f.updtDt = CURRENT_TIMESTAMP "
		 + " WHERE f.id.fileGrpId = :fileGrpId "
		 + " AND f.id.fileSeq = :fileSeq ")
	public Integer deleteFile(@Param("fileGrpId") String fileGrpId
							 , @Param("fileSeq") Integer fileSeq
							 , @Param("username") String username);
	
	@Modifying
	@Query(" UPDATE FilesEntity f "
			 + " SET f.delYn = 'Y', f.updtId = :username, f.updtDt = CURRENT_TIMESTAMP "
			 + " WHERE f.id.fileGrpId = :fileGrpId "
			 + " AND f.id.fileSeq IN :fileSeqList ")
	public Integer deleteFileList(@Param("fileGrpId") String fileGrpId
								 , @Param("fileSeqList") List<Integer> fileSeqList
								 , @Param("username") String username);
	
	public Integer findMaxId_FileSeqById_FileGrpId(String fileGrpId);
	
//	public Integer findFirstByDelYnAndId_FileGrpId(String delYn, String fileGrpId)
	
	public Integer countByDelYnAndId_FileGrpId(String delYn, String fileGrpId);
	
}
