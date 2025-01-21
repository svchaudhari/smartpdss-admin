package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.Gender;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
public interface GenderService {

	Gender createUpdate(Gender gender);
	Gender getGenderById(Long id);
	List<Gender> getAllGender(Boolean isActive);
	Gender deleteGender(Long id);
}
