package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.GasAgency;
/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */
public interface GasAgencyService {

	GasAgency createUpdate(GasAgency ga);
	GasAgency getById(Long id);
	List<GasAgency> getAll(Boolean isActive);
	GasAgency delete(Long id);
}
