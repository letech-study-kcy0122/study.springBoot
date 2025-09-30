/**
 * 
 */
package kr.letech.study.springBoot.cmmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

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
public class JacksonConfig {
	
	@Bean
	public Module hibernate5Module() {
		
		Hibernate5Module m = new Hibernate5Module();
		
		// 1) Lazy 프록시는 강제 초기화하지 않는다. (세션 문제 예방차원)
		m.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
		
		// 2) 미초기화 프록시는 식별자만 내보낸다. (프록시 속성의 직렬화 예외 예방차원)
		m.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
		
		return m;
	}

}
