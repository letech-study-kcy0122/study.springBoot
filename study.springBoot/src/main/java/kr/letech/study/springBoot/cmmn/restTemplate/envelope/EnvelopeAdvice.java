package kr.letech.study.springBoot.cmmn.restTemplate.envelope;

import java.util.UUID;

import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 
 */


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
@RestControllerAdvice
@Component
public class EnvelopeAdvice implements ResponseBodyAdvice<Object> {
	
	private static final MediaType PROBLEM = MediaType.valueOf("application/problem+json");

	@Override
	public boolean supports(MethodParameter returnType
						  , Class<? extends HttpMessageConverter<?>> converterType) {
		
		return true; //<--"모든 응답에 적용한다"
	}

	@Override
	public Object beforeBodyWrite(Object body
								, MethodParameter returnType
								, MediaType selectedContentType
								, Class<? extends HttpMessageConverter<?>> selectedConverterType
								, ServerHttpRequest request
								, ServerHttpResponse response) {
		
		if (body == null) return null;
		
		// 오류 응답, 이미 Envelope, 파일/문자열은 제외
		if (PROBLEM.equals(selectedContentType)) return body;
		if (body instanceof Envelope<?>) return body;
		if (body instanceof Resource || body instanceof CharSequence) return body;
		
		// correlationId 생성
		String cid = UUID.randomUUID().toString();
		
		// 성공 응답을 Envelope로 감싸 반환
		/*
		 * 어김없이 발생한 제너릭 타입 추론 문제
		 * return new Envelope<>( "success" , cid , body , Collections.emptyMap() ,
		 *						   Collections.emptyMap() );
		 */
		return Envelope.ok(cid, body);
	}

}
