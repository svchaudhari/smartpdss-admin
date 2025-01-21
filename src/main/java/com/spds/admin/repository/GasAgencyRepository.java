package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spds.admin.entity.GasAgency;
/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */
public interface GasAgencyRepository extends JpaRepository<GasAgency, Long>{

	List<GasAgency> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

}
