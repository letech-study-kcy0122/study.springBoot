/**
 * 
 */
package kr.letech.study.springBoot.cmmn.role.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import kr.letech.study.springBoot.cmmn.entity.AbstractCrudService;
import kr.letech.study.springBoot.cmmn.role.entity.UserRoleEntity;
import kr.letech.study.springBoot.cmmn.role.entity.UserRoleId;
import kr.letech.study.springBoot.cmmn.role.repository.UserRoleRepository;
import kr.letech.study.springBoot.cmmn.role.service.UserRoleService;
import kr.letech.study.springBoot.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <pre>
 * HibernateTimestamp: https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html?utm_source=chatgpt.com
 * JPA @Temporal: https://www.amitph.com/spring-data-jpa-embeddedid-partially/?utm_source=chatgpt.com
 * EQ/HASH @EmbeddedId: https://jakarta.ee/specifications/persistence/3.2/apidocs/jakarta.persistence/jakarta/persistence/embeddedid?utm_source=chatgpt.com
 * JPA Method 중첩: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html?utm_source=chatgpt.com
 * @MapsId: https://www.baeldung.com/spring-data-derived-queries?utm_source=chatgpt.com
 * </pre>
 * 
 * < 개정이력 >
 * 
 *  수정일			수정자			수정내용
 *  ------------------------------------------------
 *  2025-09-29		KCY				최초 생성
 *  2025-09-30		KCY				MERGE문 작업
 */
@Service @Slf4j
/* @RequiredArgsConstructor */
public class UserRoleServiceImpl
		extends AbstractCrudService<UserRoleEntity, UserRoleId> implements UserRoleService {
	
	private final UserRoleRepository userRoleRepository;
	private final EntityManager entityManager;
	private final String DEL_N = "N";

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository,
            EntityManager entityManager) {
		super(userRoleRepository);             // ★ 필수
		this.userRoleRepository = userRoleRepository;
		this.entityManager = entityManager;
	}
    
    @Override
    protected Optional<UserRoleEntity> findByBusinessKey(String key) {
    	String[] parts = key.split("_");
    	return userRoleRepository.findByDelYnAndId_UserIdAndId_UserRole(DEL_N, parts[0], parts[1]);
    }
	
    
    
	@Override
	public List<UserRoleEntity> readRolesOfUser(String userId) {
		log.debug("▩▩▩ USER_ROLE_SERVICE_IMPL.readUserRoleList() 호출.");
		return userRoleRepository.findAllByDelYnAndId_UserIdContaining(DEL_N, userId);
	}

	//0930_UPSERT와 기본 INSERT & UPDATE
	@Override
	public void saveOrUpdate(String userId, List<String> userRoles, String username) {
		log.debug("▩▩▩ USER_ROLE_SERVICE_IMPL.saveOrUpdate() 호출.");
		
		//0930_파라미터 빈값 NULL처리 (DB에 공백 문자열로 기입되는 문제가 발생하고 있음.)
		if(username.isBlank()) {
			username = null;
		}
		
		for(String userRole: userRoles) {
			if(userRoleRepository.existsByDelYnAndId_UserIdAndId_userRole(DEL_N, userId, userRole)) {
				update(userId, userRole, username);
			} else {
				insert(userId, userRole, username);
			}
		}
	}
	
	@Override
	public void insert(String userId, String userRole, String username) {
		log.debug("▩▩▩ USER_ROLE_SERVICE_IMPL.insert() 호출.");
		UserRoleEntity entity = new UserRoleEntity();
		entity.setId(new UserRoleId(userRole, userId));
		// @MapsId 일관성: FK 프록시로 맞춘다
		entity.setUser(entityManager.getReference(UserEntity.class, userId));
		entity.insert(username);
		userRoleRepository.save(entity);
	}

	@Override
	public void update(String userId, String userRole, String username) {
		log.debug("▩▩▩ USER_ROLE_SERVICE_IMPL.update() 호출.");
		UserRoleEntity entity = userRoleRepository.findByDelYnAndId_UserIdAndId_UserRole(DEL_N, userId, userRole)
				.orElseThrow();
		entity.update(username);
		entity.setDelYn(DEL_N);
		userRoleRepository.save(entity);
	}

	@Override
	public void mergeUserRoles(String userId, List<String> userRoles, String username) {
		log.debug("▩▩▩ USER_ROLE_SERVICE_IMPL.mergeUserRoles() 호출.");
		
		for(String role: userRoles) {
			if(userRoleRepository.existsById(new UserRoleId(role, userId))) {
				//이미 존재하는 권한이면 업데이트
				UserRoleEntity entity = userRoleRepository
										.findById(new UserRoleId(role, userId))
										.orElseThrow();
				entity.update(username);
				entity.setDelYn(DEL_N);
				userRoleRepository.save(entity);
			} else {
				//없으면 신규 등록
				UserRoleEntity entity = new UserRoleEntity();
				entity.setId(new UserRoleId(role, userId));
				entity.setUser(entityManager.getReference(UserEntity.class, userId));
				entity.insert(username);
				userRoleRepository.save(entity);
			}
		}
		
		//체크 해제된 권한은 논리삭제
		if(!userRoles.isEmpty()) {
			userRoleRepository.softDeleteNotInRoles(userId, userRoles, username);
		}
	}
}
