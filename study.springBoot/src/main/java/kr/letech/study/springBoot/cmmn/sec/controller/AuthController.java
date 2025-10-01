///**
// * 
// */
//package kr.letech.study.springBoot.cmmn.sec.controller;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import kr.letech.study.springBoot.cmmn.sec.JwtUtil;
//
///**
// * 
// * <pre>
// * 
// * </pre>
// * 
// * < 개정이력 >
// * 
// * 수정일 수정자 수정내용 ------------------------------------------------ 2025-09-30 KCY
// * 최초 생성
// */
//@RestController
//@RequestMapping("/sec-management/auth")
//public class AuthController {
//	private final AuthenticationManager authenticationManager;
//
//	public AuthController(AuthenticationManager authenticationManager) {
//		this.authenticationManager = authenticationManager;
//	}
//
//    @PostMapping("/login")
//    public Map<String, Object> login(@RequestBody Map<String, String> request) {
//        String username = request.get("username");
//        String password = request.get("password");
//
//        // AuthenticationManager로 사용자 인증
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//        // 권한 추출
//        List<String> roles = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        // JWT 발급
//        String token = JwtUtil.createToken(authentication.getName());
//
//        return Map.of(
//                "token", token,
//                "username", authentication.getName(),
//                "roles", roles
//        );
//    }
//    
//	/*
//	 * @GetMapping("/role") public ResponseEntity<Envelope<List<UserRoleEntity>>>
//	 * loginUser(
//	 * 
//	 * )
//	 */
//}
