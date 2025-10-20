package kr.letech.study.springBoot.cmmn.sec;
///**
// * 
// */
//package kr.letech.study.springBoot.cmmn.sec;
//
//import java.security.Key;
//import java.util.Date;
//
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
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
// */public class JwtUtil {
//	private static final String SECRET = "change_this_to_very_long_secure_secret_key_32byte";
//	private static final long EXPIRATION_MS = 1000 * 60 * 30; // 30분
//
//	private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
//
//	public static String createToken(String username) {
//		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
//				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
//				.signWith(key, SignatureAlgorithm.HS256).compact();
//	}
//
//	public static String getUsername(String token) {
//		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
//	}
//
//	public static boolean validateToken(String token) {
//		try {
//			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//			return true;
//		} catch (JwtException e) {
//			return false;
//		}
//	}
//}
