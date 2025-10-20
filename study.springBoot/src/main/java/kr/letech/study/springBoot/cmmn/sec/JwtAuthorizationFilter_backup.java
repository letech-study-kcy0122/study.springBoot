package kr.letech.study.springBoot.cmmn.sec;
///**
// * 
// */
//package kr.letech.study.springBoot.cmmn.sec;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
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
//
//
//public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
//
//    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        String header = request.getHeader("Authorization");
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.replace("Bearer ", "");
//            if (JwtUtil.validateToken(token)) {
//                String username = JwtUtil.getUsername(token);
//                UsernamePasswordAuthenticationToken auth =
//                        new UsernamePasswordAuthenticationToken(username, null, null);
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}
