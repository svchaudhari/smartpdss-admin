package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.CasteCategory;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
public interface CasteCategoryService {

	CasteCategory createUpdate(CasteCategory casteCategory);
	CasteCategory getCasteCategoryById(Long id);
	List<CasteCategory> getAllCasteCategory(Boolean isActive);
	CasteCategory deleteCasteCategory(Long id);
	
	
}
