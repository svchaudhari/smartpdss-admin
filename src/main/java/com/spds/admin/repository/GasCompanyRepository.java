package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spds.admin.entity.GasCompany;
/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */
public interface GasCompanyRepository extends JpaRepository<GasCompany, Long>{

	List<GasCompany> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

}
