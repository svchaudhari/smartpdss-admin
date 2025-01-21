package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.PdsOwnershipType;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface PdsOwnershipTypeService {
	PdsOwnershipType createState(PdsOwnershipType pdsowner);
	PdsOwnershipType getPdsOwnershipById(Long id);
	List<PdsOwnershipType> getAllPdsOwnership(Boolean isActive);
	PdsOwnershipType deletePdsOwnership(Long id);
}
