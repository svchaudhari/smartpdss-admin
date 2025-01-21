package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.ProcurementType;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface ProcurementTypeService {

	ProcurementType createState(ProcurementType proctype);
	ProcurementType getProcurmentTypeById(Long id);
	List<ProcurementType> getAllProcurementType(Boolean isActive);
	ProcurementType deleteProcurementType(Long id);
}
