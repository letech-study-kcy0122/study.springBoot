/**
 * 
 */
package kr.letech.study.springBoot.cmmn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * <pre>
 * 
 * </pre>
 * 
 * < 개정이력 >
 * 
 * 수정일 			수정자 			수정내용
 * ------------------------------------------------
 * 2025-10-12 		KCY				최초 생성
 */
@Configuration
public class CORSConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8082", "http://localhost:8080")
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true).maxAge(3600);
			}
		};
	}
}
