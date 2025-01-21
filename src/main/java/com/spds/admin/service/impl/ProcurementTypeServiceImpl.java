package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.ProcurementType;
import com.spds.admin.repository.ProcurementTypeRepository;
import com.spds.admin.service.ProcurementTypeService;

import jakarta.persistence.EntityNotFoundException;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */

@Service
public class ProcurementTypeServiceImpl implements ProcurementTypeService{

	@Autowired
	private ProcurementTypeRepository procurementTypeRepo;
	
	@Override
	public ProcurementType createState(ProcurementType proctype) {
		// TODO Auto-generated method stub
		Optional<ProcurementType> st=procurementTypeRepo.findById(proctype.getId());
		if(st.isPresent()) {
			proctype.setCreatedBy(st.get().getCreatedBy());
			proctype.setCreatedOn(st.get().getCreatedOn());
		}
		return procurementTypeRepo.save(proctype);
	}

	@Override
	public ProcurementType getProcurmentTypeById(Long id) {
		// TODO Auto-generated method stub
		return procurementTypeRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Procurement Type not found with ID: " + id));
	}

	@Override
	public List<ProcurementType> getAllProcurementType(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return procurementTypeRepo.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
			}
			else {
				return procurementTypeRepo.findAll();
			}
	}

	@Override
	public ProcurementType deleteProcurementType(Long id) {
		// TODO Auto-generated method stub
		ProcurementType procType=getProcurmentTypeById(id);
		procType.setActive(false);
		procType.setDeleted(true);
		return procurementTypeRepo.save(procType);
	}

}
