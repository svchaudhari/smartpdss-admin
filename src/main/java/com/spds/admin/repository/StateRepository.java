package com.spds.admin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.State;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface StateRepository extends JpaRepository<State, Long>{
	
	@Query(value="select * from master.state where is_active=true and is_deleted=false",nativeQuery=true)
	List<State> findAllByIsActiveIsTrue();

	@Query(value="select * from master.state where is_deleted=false",nativeQuery=true)
	List<State> findAllIsDeletedFalse();

}
