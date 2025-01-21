package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spds.admin.dto.RoleOffice;
import com.spds.admin.entity.UserAccessMapping;

/***
 * 
 *@author abinjola
 *This class was creaded on 08-Dec-2024.
 */
public interface UserAccessRepository extends JpaRepository<UserAccessMapping, Long>{

	@Query(value = "select * from ua.user_access_mapping uam where uam.user_id=:userId and uam.is_active=true and uam.is_deleted=false",nativeQuery = true)
	List<RoleOffice> getUserPrivilagesByUserId(@Param("userId") Long userId);
}
