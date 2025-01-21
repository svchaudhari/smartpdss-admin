package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.GasCompany;
/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */
public interface GasCompanyService {

	GasCompany createUpdate(GasCompany gc);
	GasCompany getById(Long id);
	List<GasCompany> getAll(Boolean isActive);
	GasCompany delete(Long id);
}
