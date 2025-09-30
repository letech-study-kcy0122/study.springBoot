/**
 * 
 */
package kr.letech.study.springBoot.cmmn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * <pre>
 * 실무에서는 주로 모든 엔티티에서 등록/수정 정보를 추적한다.
 * 공통 속성들을 모은 BaseEntity 클래스를 만들었다.
 * 실제 객체화 할 일이 없기 때문에 추상 클래스로 만들었다.
 * 상위 클래스는 @MappedSuperclass를 통해
 * 단순히 속성 정보만 모은 클래스임을 명시해줘야한다.
 * 
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-09-26		KCY				최초 생성
 */
@MappedSuperclass @Getter @Setter
public abstract class BaseEntity {
	
	@Column(name="RGST_ID")
	protected String rgstId;	
	
	@Column(name="RGST_DT") @CreationTimestamp @Temporal(TemporalType.TIMESTAMP)
	protected Date rgstDt;
	
	@Column(name="UPDT_ID")
	protected String updtId;
	
	@Column(name="UPDT_DT") @UpdateTimestamp @Temporal(TemporalType.TIMESTAMP)
	protected Date updtDt;
	
	@Column(name="DEL_YN", nullable=false)
	protected String delYn = "N";	//<-- default Value
}
