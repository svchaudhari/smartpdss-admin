package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.spds.admin.entity.GasAgency;
import com.spds.admin.repository.GasAgencyRepository;
import com.spds.admin.service.GasAgencyService;

import jakarta.persistence.EntityNotFoundException;

public class GasAgencyServiceImpl implements GasAgencyService{

	@Autowired
	private GasAgencyRepository gasAgencyRepo;
	
	@Override
	public GasAgency createUpdate(GasAgency ga) {
		// TODO Auto-generated method stub
		Optional<GasAgency> st=gasAgencyRepo.findById(ga.getId());
		if(st.isPresent()) {
			ga.setCreatedBy(st.get().getCreatedBy());
			ga.setCreatedOn(st.get().getCreatedOn());
		}
		return gasAgencyRepo.save(ga);
	}

	@Override
	public GasAgency getById(Long id) {
		// TODO Auto-generated method stub
		return gasAgencyRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Gas Agency not found with ID: "+id));
	}

	@Override
	public List<GasAgency> getAll(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return gasAgencyRepo.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
			}
			else {
				return gasAgencyRepo.findAll();
			}
	}

	@Override
	public GasAgency delete(Long id) {
		// TODO Auto-generated method stub
		GasAgency ga=getById(id);
		ga.setActive(false);
		ga.setDeleted(true);
		return gasAgencyRepo.save(ga);
	}

}
