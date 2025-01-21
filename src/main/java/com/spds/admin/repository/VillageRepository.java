package com.spds.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.Village;

import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Transactional
public interface VillageRepository extends JpaRepository<Village, Long>{

	@Query(value="select * from master.village where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	List<Village> findByIdIsActiveIsTrueAndIsDeletedIsFalse(Long id);

	List<Village> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

	List<Village> findAllById(Long id);
}
