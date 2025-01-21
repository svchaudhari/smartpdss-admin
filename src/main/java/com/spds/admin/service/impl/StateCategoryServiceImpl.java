package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.ProcurementType;
import com.spds.admin.entity.StateCategory;
import com.spds.admin.repository.StateCategoryRepository;
import com.spds.admin.service.StateCategoryService;

import jakarta.persistence.EntityNotFoundException;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
@Service
public class StateCategoryServiceImpl implements StateCategoryService{

	@Autowired
	private StateCategoryRepository stateCategoryRepo;
	
	@Override
	public StateCategory createState(StateCategory statescheme) {
		// TODO Auto-generated method stub
		Optional<StateCategory> st=stateCategoryRepo.findById(statescheme.getId());
		if(st.isPresent()) {
			statescheme.setCreatedBy(st.get().getCreatedBy());
			statescheme.setCreatedOn(st.get().getCreatedOn());
		}
		return stateCategoryRepo.save(statescheme);
	}

	@Override
	public StateCategory getStateSchemeById(Long id) {
		// TODO Auto-generated method stub
		return stateCategoryRepo.findById(id).orElseThrow(()->new EntityNotFoundException("State Scheme not found with ID: " + id));
	}

	@Override
	public List<StateCategory> getAllStateScheme(Boolean isActive) {
		if(isActive==true) {
			return stateCategoryRepo.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
			}
			else {
				return stateCategoryRepo.findAll();
			}
	}

	@Override
	public StateCategory deleteStateScheme(Long id) {
		StateCategory stateScheme=getStateSchemeById(id);
		stateScheme.setActive(false);
		stateScheme.setDeleted(true);
		return stateCategoryRepo.save(stateScheme);
	}

}
