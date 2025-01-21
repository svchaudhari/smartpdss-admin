package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.Gender;
import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Transactional
public interface GenderRepository extends JpaRepository<Gender, Long>{

	@Query(value="select * from master.district where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	List<Gender> findByIdIsActiveIsTrueAndIsDeletedIsFalse(int gtTypeId);

	List<Gender> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

	List<Gender> findById(int gtTypeId);
}
