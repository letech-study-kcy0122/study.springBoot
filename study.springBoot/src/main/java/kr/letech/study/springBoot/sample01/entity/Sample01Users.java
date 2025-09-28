/**
 * 
 */
package kr.letech.study.springBoot.sample01.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

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
 *  2025-09-26		KCY				최초 생성
 */
@Entity
@Getter
@Setter
public class Sample01Users {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	private String username;
}
