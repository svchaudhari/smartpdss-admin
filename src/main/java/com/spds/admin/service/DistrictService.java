package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.District;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface DistrictService {

	District createUpdate(District district);
	District getDictrictById(Long id);
	List<District> getAllDistrict(Boolean isActive);
	District deleteDistrict(Long id);
	List<District> getDistrictByStateId(Long stateId, Boolean isActive);
	
}
