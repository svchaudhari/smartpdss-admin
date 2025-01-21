package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spds.admin.entity.ProcurementType;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface ProcurementTypeRepository extends JpaRepository<ProcurementType, Long>{

	List<ProcurementType> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

}
