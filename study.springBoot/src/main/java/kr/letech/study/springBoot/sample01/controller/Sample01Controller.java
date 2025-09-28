/**
 * 
 */
package kr.letech.study.springBoot.sample01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.letech.study.springBoot.sample01.entity.Sample01Users;
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
@RestController
@RequiredArgsConstructor
public class Sample01Controller {

    private final Sample01Service sampleService;
    
    /*
     * @GetMapping("/user") public ResponseEntity<?>
     */

    @GetMapping(value = "/user")
    public List<Sample01Users> getUsers( @RequestParam(required = false, defaultValue = "") String name ){
        return sampleService.getUsersService( name );
    }

    @PostMapping(value = "/user")
    public String createUser(@RequestBody Sample01Users user){
        return sampleService.createUserService(user);
    }
}
