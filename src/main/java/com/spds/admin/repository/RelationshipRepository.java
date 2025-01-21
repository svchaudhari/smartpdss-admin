package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.Relationship;

import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Transactional
public interface RelationshipRepository extends JpaRepository<Relationship, Long>{

	@Query(value="select * from master.relationship where state_id=?1 and is_active=true and is_deleted=false",nativeQuery=true)
	List<Relationship> findByRsCodeIsActiveIsTrueAndIsDeletedIsFalse(String gtTypeId);

	List<Relationship> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

	List<Relationship> findByRsCode(String rsCode);
}
