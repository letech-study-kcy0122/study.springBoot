/**
 * 
 */
package kr.letech.study.springBoot.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.letech.study.springBoot.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;

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
@DataJpaTest @Slf4j
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TestUserRepository {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Test method for {@link kr.letech.study.springBoot.user.repository.UserRepository#findAllByDelYn(java.lang.String)}.
	 */
	@Test
	@DisplayName("delYn = 'N' 인 사용자 전체 조회")
	void testFindAllByDelYn() {
		// given
		UserEntity user1 = new UserEntity();
		user1.setUserId("hong");
		user1.setUserPw("1234");
		user1.setUserNm("홍길동");
		user1.setDelYn("N");
		userRepository.save(user1);
		
		UserEntity user2 = new UserEntity();
		user2.setUserId("kim");
		user2.setUserPw("5678");
		user2.setUserNm("김철수");
		user2.setDelYn("Y");
		userRepository.save(user2);
		
		// when
		List<UserEntity> result = userRepository.findAllByDelYnOrderByRgstDtDesc("N");
		
		// then
		assertThat(result).hasSize(1);
		assertThat(result.get(0).getUserId()).isEqualTo("hong");
		
		log.debug("▩ ----- User1 : {}", user1);
		/**
		 * 0926_테스트 결과:
		 */
	}

	/**
	 * Test method for {@link kr.letech.study.springBoot.user.repository.UserRepository#findFirstByUserIdAndDelYn(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindFirstByUserIdAndDelYn() {
	}

}
