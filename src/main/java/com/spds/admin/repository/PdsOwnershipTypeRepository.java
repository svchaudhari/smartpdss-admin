package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spds.admin.entity.PdsOwnershipType;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface PdsOwnershipTypeRepository extends JpaRepository<PdsOwnershipType, Long>{

	List<PdsOwnershipType> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

}
