///**
// * 
// */
//package kr.letech.study.springBoot.cmmn.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import kr.letech.study.springBoot.cmmn.sec.JwtAuthorizationFilter;
//
///**
// * 
// * <pre>
// * 
// * </pre>
// * 
// * < 개정이력 >
// * 
// *  수정일			수정자			수정내용
// *  ------------------------------------------------
// *  2025-09-30		KCY				최초 생성
// */
//@Configuration
//public class SecurityConfig {
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//    
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http
//			.csrf(AbstractHttpConfigurer::disable)
//			.httpBasic(AbstractHttpConfigurer::disable)
//			.authorizeHttpRequests(auth -> auth
//				.antMatchers("/sec-management/auth/**").permitAll()
//				.anyRequest().permitAll()
////				.anyRequest().authenticated()
//			).addFilter(new JwtAuthorizationFilter(authenticationManager(http.getSharedObject(AuthenticationConfiguration.class))));
//		return http.build();
//	}
//}
