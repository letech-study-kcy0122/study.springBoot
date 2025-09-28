/**
 * 
 */
package kr.letech.study.springBoot.sample01.service;

import java.util.List;

import kr.letech.study.springBoot.sample01.entity.Sample01Users;

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
public interface Sample01Service {
    public List<Sample01Users> getUsersService(String name);
    public String createUserService(Sample01Users user);
}
