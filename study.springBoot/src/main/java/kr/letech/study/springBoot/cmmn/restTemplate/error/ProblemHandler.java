/**
 * 
 */
package kr.letech.study.springBoot.cmmn.restTemplate.error;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * <pre>
 * 	전역 예외 핸들러
 * 	- Validation 오류 -> 400 ProblemDetail
 * 	- 그 외 오류 -> 500 감추기
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-09-29		KCY				최초 생성
 */
@RestControllerAdvice
public class ProblemHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ProblemDetail> validation(MethodArgumentNotValidException e
												  , HttpServletRequest req) {
		
		List<Map<String, String>> errors = e.getBindingResult().getFieldErrors().stream()
											.map(fe -> Map.of("field", fe.getField()
															, "message", fe.getDefaultMessage()))
											.collect(Collectors.toList());
		
		ProblemDetail problem = new ProblemDetail(
				"http://localhost:8081/validation"
				, "Validation failed"
				, HttpStatus.BAD_REQUEST.value()
				, "입력값 검증에 실패!!!"
				, req.getRequestURI()
				, Map.of("errors", errors)
		);
		
		return ResponseEntity.badRequest()
				.contentType(MediaType.valueOf("application/problem+json"))
				.body(problem);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ProblemDetail> unknown(Exception e
											   , HttpServletRequest req) {
		ProblemDetail problem = new ProblemDetail(
				"http://localhost:8081/internal"
				, "Internal Server Error: 500"
				, HttpStatus.INTERNAL_SERVER_ERROR.value()
				, e.getMessage()
				, req.getRequestURI()
				, Map.of()
		);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.contentType(MediaType.valueOf("application/problem+json"))
				.body(problem);
	}
	
}
