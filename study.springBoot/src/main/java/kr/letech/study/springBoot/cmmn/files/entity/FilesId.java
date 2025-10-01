/**
 * 
 */
package kr.letech.study.springBoot.cmmn.files.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
@SuppressWarnings("serial")
@Embeddable @Getter @Setter @ToString
@EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class FilesId implements Serializable {
	@Column(name="FILE_GRP_ID")		private String fileGrpId;
	@Column(name="FILE_SEQ")		private Integer fileSeq;
}
