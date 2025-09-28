/**
 * 
 */
package kr.letech.study.springBoot.sample01.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.sample01.entity.Sample01Users;
import kr.letech.study.springBoot.sample01.repository.Sample01Repository;
import kr.letech.study.springBoot.sample01.service.Sample01Service;
import lombok.RequiredArgsConstructor;

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
 *  2025-09-26		KCY				최초 생성
 */
@Service
@RequiredArgsConstructor
public class Sample01ServiceImpl implements Sample01Service {

    private final Sample01Repository sampleRepository;

    public List<Sample01Users> getUsersService(String name){
        if(name.isBlank()) // name 파라미터가 Null이면 전체 user를 리턴
            return sampleRepository.findAll();
        else  // name 이 존재를 하면, Like 쿼리로 2개만 리턴
            return sampleRepository.findFirst2ByUsernameLikeOrderByIDDesc(name);
    }

    public String createUserService(Sample01Users user){
         sampleRepository.save(user); // User Insert 쿼리 수행
         return "등록 완료";
    }
}
