package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spds.admin.entity.Role;

/***
 * 
 *@author abinjola
 *This class was creaded on 08-Dec-2024.
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query(value = "select * from ua.role r where case when :isActive is true then r.is_active=true else true end",nativeQuery = true)
	List<Role> getAll(@Param("isActive") Boolean isActive);
}
