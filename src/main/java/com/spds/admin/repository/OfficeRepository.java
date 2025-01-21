package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spds.admin.entity.Office;

/***
 * 
 *@author abinjola
 *This class was creaded on 08-Dec-2024.
 */
public interface OfficeRepository extends JpaRepository<Office, Long>{

	@Query(value = "select * from ua.office f where case when :isActive is true then f.is_active=true else true end",nativeQuery = true)
	List<Office> getAll(@Param("isActive") Boolean isActive);
}
