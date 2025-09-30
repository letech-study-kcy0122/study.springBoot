/**
 * 
 */
package kr.letech.study.springBoot.cmmn.role.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import kr.letech.study.springBoot.cmmn.entity.BaseEntity;
import kr.letech.study.springBoot.cmmn.entity.UpdatableEntity;
import kr.letech.study.springBoot.user.entity.UserEntity;
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
 *  2025-09-29		KCY				최초 생성
 */
@Entity @Table(name="USER_ROLE") @Getter @Setter @ToString(exclude = "user")
@NoArgsConstructor @AllArgsConstructor
public class UserRoleEntity extends BaseEntity implements UpdatableEntity {
	
	@EmbeddedId @JsonUnwrapped //<--복합키의 계층구조를 평탄화시키는 어노테이션.
	private UserRoleId id;
	
	@MapsId("userId")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	private UserEntity user;

	@Override
	public void update(String username) {
		this.updtId = username;
//		this.updtDt = LocalDateTime.now(); 어노테이션으로 처리
//		this.delYn = "N"; 생성자에서 처리
		
	}
	
	@Override
	public void insert(String username) {
		this.rgstId = username;
		this.updtId = username;
	}
	
	@Override
	public String getBusinessKey() {
		return id.getUserId() + "_" + id.getUserRole();
	}
}