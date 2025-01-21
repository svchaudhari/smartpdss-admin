package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.StateCategory;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface StateCategoryService {
	StateCategory createState(StateCategory statescheme);
	StateCategory getStateSchemeById(Long id);
	List<StateCategory> getAllStateScheme(Boolean isActive);
	StateCategory deleteStateScheme(Long id);
}
