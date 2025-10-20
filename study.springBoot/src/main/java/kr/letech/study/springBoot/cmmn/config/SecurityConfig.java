/**
 * 
 */
package kr.letech.study.springBoot.cmmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * <pre>
 * Spring Security starter를 주입하면 자동설정되는 보안/인가 프로세스가 있음.
 * 아래와 같이 막아놓으면 된다더라.
 * 
 * 		@SpringBootApplication(exclude = {
 * 		  org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
 * 		  org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration.class
 * 		})
 * 		public class ApiApplication {}
 * 
 * 또는,
 * 
 * 		spring.autoconfigure.exclude=\
 * 		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,\
 * 		org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
 *
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-09-30		KCY				최초 생성
 *  2025-10-16		KCY				비밀번호 2차인증을 위한 Crypto모듈 의존성 추가
 */
@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
