package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.District;

import jakarta.transaction.Transactional;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
@Transactional
public interface DistrictRepository extends JpaRepository<District, Long>{

	@Query(value="select * from master.district where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	List<District> findByStateIdIsActiveIsTrueAndIsDeletedIsFalse(Long stateId);

	List<District> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

	List<District> findByStateId(Long stateId);
}
