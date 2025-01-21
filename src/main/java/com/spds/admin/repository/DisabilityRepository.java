package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.Disability;
import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Transactional
public interface DisabilityRepository extends JpaRepository<Disability, Long>{

	@Query(value="select * from master.disability where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	List<Disability> findByDisabilityCodeIsActiveIsTrueAndIsDeletedIsFalse(String gtTypeId);

	List<Disability> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

	List<Disability> findByDisabilityCode(String disabilityCode);
}
