package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.CasteCategory;
import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Transactional
public interface CasteCategoryRepository extends JpaRepository<CasteCategory, Long>{

	@Query(value="select * from master.casteCategory where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	List<CasteCategory> findByTehsilCodeIsActiveIsTrueAndIsDeletedIsFalse(int casteCategoryCode);

	List<CasteCategory> findAllByIsActiveIsTrueAndIsDeletedIsFalse();
}
