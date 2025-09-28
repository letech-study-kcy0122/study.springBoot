/**
 * 
 */
package kr.letech.study.springBoot.sample01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.letech.study.springBoot.sample01.entity.Sample01Users;

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
@Repository
public interface Sample01Repository extends JpaRepository<Sample01Users, Long> {
	
	List<Sample01Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);

}
