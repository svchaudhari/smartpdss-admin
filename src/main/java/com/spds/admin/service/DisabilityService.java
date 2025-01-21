package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.Disability;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
public interface DisabilityService {

	Disability createUpdate(Disability disability);
	Disability getDisabilityById(Long id);
	List<Disability> getAllDisability(Boolean isActive);
	Disability deleteDisability(Long id);
	List<Disability> getDisabilityByDisabilityCode(String tehsilCode, Boolean isActive);
}
