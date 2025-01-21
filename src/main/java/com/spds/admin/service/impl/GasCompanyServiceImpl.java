package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.GasCompany;
import com.spds.admin.repository.GasCompanyRepository;
import com.spds.admin.service.GasCompanyService;

import jakarta.persistence.EntityNotFoundException;

/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */
@Service
public class GasCompanyServiceImpl implements GasCompanyService{

	@Autowired
	private GasCompanyRepository gasCompanyRepo;
	
	@Override
	public GasCompany createUpdate(GasCompany gc) {
		// TODO Auto-generated method stub
		Optional<GasCompany> st=gasCompanyRepo.findById(gc.getId());
		if(st.isPresent()) {
			gc.setCreatedBy(st.get().getCreatedBy());
			gc.setCreatedOn(st.get().getCreatedOn());
		}
		return gasCompanyRepo.save(gc);
	}

	@Override
	public GasCompany getById(Long id) {
		// TODO Auto-generated method stub
		return gasCompanyRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Gas Company not found with ID: "+id));
	}

	@Override
	public List<GasCompany> getAll(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return gasCompanyRepo.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
			}
			else {
				return gasCompanyRepo.findAll();
			}
	}

	@Override
	public GasCompany delete(Long id) {
		// TODO Auto-generated method stub
		GasCompany gc=getById(id);
		gc.setActive(false);
		gc.setDeleted(true);
		return gasCompanyRepo.save(gc);
	}

}
