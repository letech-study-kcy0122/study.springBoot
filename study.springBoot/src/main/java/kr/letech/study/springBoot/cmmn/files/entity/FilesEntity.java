/**
 * 
 */
package kr.letech.study.springBoot.cmmn.files.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import kr.letech.study.springBoot.cmmn.entity.BaseEntity;
import kr.letech.study.springBoot.cmmn.entity.UpdatableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
 *  2025-09-30		KCY				최초 생성
 */
@Entity @Table(name="FILES") @Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class FilesEntity extends BaseEntity implements UpdatableEntity {
	
	@EmbeddedId @JsonUnwrapped
	private FilesId id;
	
	@Column(name="FILE_ORG_NM")		private String fileOrgNm;
	@Column(name="FILE_REF_NM")		private String fileRefNm;
	@Column(name="FILE_SIZE")		private Long   fileSize;
	@Column(name="FILE_DIR")		private String fileDir;
	@Column(name="ATTACH_TYPE")		private String attachType;
	@Column(name="MIME_TYPE")		private String mimeType;
	@Column(name="LAST_MODIFIED")	private String lastModified;
	
	@Override
	public void update(String username) {
		this.updtId = username;
	}
	@Override
	public void insert(String username) {
		this.rgstId = username;
		this.updtId = username;
	}
	@Override
	public String getBusinessKey() {
		return id.getFileGrpId() + "_" + id.getFileSeq();
	}
}
