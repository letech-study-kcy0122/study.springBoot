/**
 * 
 */
package kr.letech.study.springBoot.cmmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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
@Configuration
public class RestConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
