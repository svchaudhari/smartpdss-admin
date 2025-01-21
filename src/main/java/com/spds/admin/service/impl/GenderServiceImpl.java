package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.Gender;
import com.spds.admin.repository.GenderRepository;
import com.spds.admin.service.GenderService;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Service
public class GenderServiceImpl implements GenderService{

	@Autowired
	private GenderRepository genderRepository;
	
	@Override
	public Gender createUpdate(Gender gender) {
		// TODO Auto-generated method stub
		Optional<Gender> st=genderRepository.findById(gender.getId());
		if(st.isPresent()) {
			gender.setCreatedBy(st.get().getCreatedBy());
			gender.setCreatedOn(st.get().getCreatedOn());
		}
		return genderRepository.save(gender);
	}

	@Override
	public Gender getGenderById(Long id) {
		// TODO Auto-generated method stub
		return genderRepository.findById(id).orElseThrow(()-> new RuntimeException("Gender not found with ID: "+id));
	}

	@Override
	public List<Gender> getAllGender(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return genderRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return genderRepository.findAll();
			
		}
		
	}

	@Override
	public Gender deleteGender(Long id) {
		// TODO Auto-generated method stub
		Gender gender=getGenderById(id);
		gender.setActive(false);
		gender.setDeleted(true);
		return genderRepository.save(gender);
	}

}
