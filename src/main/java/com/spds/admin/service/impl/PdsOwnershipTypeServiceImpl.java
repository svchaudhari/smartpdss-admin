package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.PdsOwnershipType;
import com.spds.admin.entity.ProcurementType;
import com.spds.admin.repository.PdsOwnershipTypeRepository;
import com.spds.admin.service.PdsOwnershipTypeService;

import jakarta.persistence.EntityNotFoundException;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
@Service
public class PdsOwnershipTypeServiceImpl implements PdsOwnershipTypeService{

	@Autowired
	private PdsOwnershipTypeRepository pdsOwnershipRepo;
	
	@Override
	public PdsOwnershipType createState(PdsOwnershipType pdsowner) {
		// TODO Auto-generated method stub
		Optional<PdsOwnershipType> st=pdsOwnershipRepo.findById(pdsowner.getId());
		if(st.isPresent()) {
			pdsowner.setCreatedBy(st.get().getCreatedBy());
			pdsowner.setCreatedOn(st.get().getCreatedOn());
		}
		return pdsOwnershipRepo.save(pdsowner);
	}

	@Override
	public PdsOwnershipType getPdsOwnershipById(Long id) {
		// TODO Auto-generated method stub
		return pdsOwnershipRepo.findById(id).orElseThrow(()->new EntityNotFoundException("PdsOwnershipType Scheme not found with ID: " + id));
	}

	@Override
	public List<PdsOwnershipType> getAllPdsOwnership(Boolean isActive) {
		if(isActive==true) {
			return pdsOwnershipRepo.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
			}
			else {
				return pdsOwnershipRepo.findAll();
			}
	}

	@Override
	public PdsOwnershipType deletePdsOwnership(Long id) {
		PdsOwnershipType pdsOwnner=getPdsOwnershipById(id);
		pdsOwnner.setActive(false);
		pdsOwnner.setDeleted(true);
		return pdsOwnershipRepo.save(pdsOwnner);
	}

	
}
