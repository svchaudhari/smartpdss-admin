package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.Disability;
import com.spds.admin.repository.DisabilityRepository;
import com.spds.admin.service.DisabilityService;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Service
public class DisabilityServiceImpl implements DisabilityService{

	@Autowired
	private DisabilityRepository disabilityRepository;
	
	@Override
	public Disability createUpdate(Disability disability) {
		Optional<Disability> st=disabilityRepository.findById(disability.getId());
		if(st.isPresent()) {
			disability.setCreatedBy(st.get().getCreatedBy());
			disability.setCreatedOn(st.get().getCreatedOn());
		}
		return disabilityRepository.save(disability);
	}

	@Override
	public Disability getDisabilityById(Long id) {
		// TODO Auto-generated method stub
		return disabilityRepository.findById(id).orElseThrow(()-> new RuntimeException("Disability not found with ID: "+id));
	}

	@Override
	public List<Disability> getAllDisability(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return disabilityRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return disabilityRepository.findAll();
			
		}
		
	}

	@Override
	public Disability deleteDisability(Long id) {
		// TODO Auto-generated method stub
		Disability disability=getDisabilityById(id);
		disability.setActive(false);
		disability.setDeleted(true);
		return disabilityRepository.save(disability);
	}

	@Override
	public List<Disability> getDisabilityByDisabilityCode(String disabilityCode,Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return disabilityRepository.findByDisabilityCodeIsActiveIsTrueAndIsDeletedIsFalse(disabilityCode);
		}else {
			return disabilityRepository.findByDisabilityCode(disabilityCode);
		}
		
	}

	

}
