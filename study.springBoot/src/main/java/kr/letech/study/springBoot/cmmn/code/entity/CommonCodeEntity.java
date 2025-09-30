/**
 * 
 */
package kr.letech.study.springBoot.cmmn.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.letech.study.springBoot.cmmn.entity.BaseEntity;
import lombok.Getter;
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
 *  2025-09-29		KCY				최초 생성
 */
@Entity @Table(name="COMMON_CODE") @Getter @Setter @ToString
public class CommonCodeEntity extends BaseEntity {
	@Id @Column(name="CMMN_CD")		private String cmmnCd;
	@Column(name="CMMN_GRP_CD")		private String cmmnGrpCd;
	@Column(name="CMMN_NM")			private String cmmnNm;
	@Column(name="CMMN_DESC")		private String cmmnDesc;
}
