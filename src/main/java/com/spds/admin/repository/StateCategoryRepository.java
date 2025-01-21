package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spds.admin.entity.StateCategory;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface StateCategoryRepository extends JpaRepository<StateCategory, Long>{

	List<StateCategory> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

}
