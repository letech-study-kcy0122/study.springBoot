/**
 * 
 */
package kr.letech.study.springBoot.user.entity;

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
 * Caused by: java.sql.SQLSyntaxErrorException: Unknown column 'DTYPE' in 'INSERT INTO'
 * SINGLE_TABLE 전략은 부모/자식 엔터티를 한 테이블에 저장하려는 시도.
 * 그걸 뭐 어떻게 구분한단 건진 잘 모르겠지만,
 * 구분을 위해 DTYPE이란 컬럼을 자동으로 만들어주려고 한다.
 * 실제 USERS에는 그딴 컬럼이 없으니 INSERT 과정에서 DTYPE에 값 할당에 오류가 발생.
 * 
 * ==> BaseVO에는 상속 구조가 필요 없다.
 * 	그러니 @Inheritance 어노테이션 무용
 * ==> @DiscriminatorColumn 어노테이션은 상속엔터티에서 DTYPE 컬럼을 정의하기 위해 붙인다.
 * 	(name="DTYPE") 속성으로 컬럼명 수정 가능
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-09-26		KCY				최초 생성
 */
@Entity @Table(name="USER") @Getter @Setter @ToString(exclude = "userPw")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn
//@SQLDelete(sql = " UPDATE USER "
//			   + " SET DEL_YN = 'Y', "
//			   + "     UPDT_ID = ?, "
//			   + "     UPDT_DT = ?, "
//			   + " WHERE USER_ID = ? ")
//@Where(clause  = " DEL_YN = 'N' ")
public class UserEntity extends BaseEntity {
	
	@Id @Column(name="USER_ID")
	private String userId;
	
	@Column(name = "USER_PW") /* @JsonIgnore - 막아놓으면 8080에서 받아올 때 지워버림.. Entity와 DTO 게층을 분리해놓는 방향이 좋다 하드라. */
	private String userPw;
	
	@Column(name="USER_NM")
	private String userNm;
	
	@Column(name="REGNO1")
	private Integer regno1;			
	
	@Column(name="REGNO2")
	private Integer regno2;
	
	@Column(name="PROFILE_GRP_ID")
	private String profileGrpId;
	
}
