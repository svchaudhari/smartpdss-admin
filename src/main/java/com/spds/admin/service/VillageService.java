package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.Village;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
public interface VillageService {

	Village createUpdate(Village village);
	Village getVillageById(Long id);
	List<Village> getAllVillage(Boolean isActive);
	Village deleteVillage(Long id);
	List<Village> getVillageById(Long id, Boolean isActive);
}
