package com.spds.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spds.admin.entity.User;

import jakarta.transaction.Transactional;
/**
 * 
 *@author prakash
 *created 02 Jan 2025
 */
@Transactional
public interface NewRegistrationRepository extends JpaRepository<User, Long>{

	
}
