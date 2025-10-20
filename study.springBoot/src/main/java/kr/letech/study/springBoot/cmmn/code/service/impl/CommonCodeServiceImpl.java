/**
 * 
 */
package kr.letech.study.springBoot.cmmn.code.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.cmmn.code.entity.CommonCodeEntity;
import kr.letech.study.springBoot.cmmn.code.repository.CommonCodeRepository;
import kr.letech.study.springBoot.cmmn.code.service.CommonCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Service @RequiredArgsConstructor @Slf4j
public class CommonCodeServiceImpl implements CommonCodeService {

	private final CommonCodeRepository commonCodeRepository;
	private final String DEL_YN = "N";
	
	@Override
	public List<CommonCodeEntity> readCommonCodeList(String cmmnGrpCd) {
		log.debug("▩▩▩ COMMON_CODE_SERVICE_IMPL.readCommonCodeList() 호출.");
		List<CommonCodeEntity> cmmnList = new ArrayList<>();
		
		if(!cmmnGrpCd.isBlank()) {
			cmmnList = commonCodeRepository.findAllByDelYnAndCmmnGrpCdContaining(DEL_YN, cmmnGrpCd);
		}
		
		return cmmnList;
	}
	

}
