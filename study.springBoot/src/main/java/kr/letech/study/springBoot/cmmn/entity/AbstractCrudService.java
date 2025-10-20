/**
 * 
 */
package kr.letech.study.springBoot.cmmn.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

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
 *  2025-09-30		KCY				최초 생성
 */
@Transactional
public abstract class AbstractCrudService<T extends UpdatableEntity, ID> {

	protected final JpaRepository<T, ID> repository;

	protected AbstractCrudService(JpaRepository<T, ID> repository) {
		this.repository = repository;
	}

	// 공통 SaveOrUpdate
	public T saveOrUpdate(T entity, String actorId) {
	    Optional<T> existing = findByBusinessKey(entity.getBusinessKey());
	    if (existing.isPresent()) {
	        T found = existing.get();
	        // 필요 시 entity의 변경 필드 → found로 복사
	        found.update(actorId);
	        return repository.save(found);
	    } else {
	        entity.insert(actorId);
	        return repository.save(entity);
	    }
	}

	// 구현체가 key로 검색하는 로직을 제공해야 함
	protected abstract Optional<T> findByBusinessKey(String key);
}
