package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.CasteCategory;
import com.spds.admin.repository.CasteCategoryRepository;
import com.spds.admin.service.CasteCategoryService;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Service
public class CasteCategoryServiceImpl implements CasteCategoryService{

	@Autowired
	private CasteCategoryRepository casteCategoryRepository;
	
	@Override
	public CasteCategory createUpdate(CasteCategory casteCategory) {
		// TODO Auto-generated method stub
		Optional<CasteCategory> st=casteCategoryRepository.findById(casteCategory.getId());
		if(st.isPresent()) {
			casteCategory.setCreatedBy(st.get().getCreatedBy());
			casteCategory.setCreatedOn(st.get().getCreatedOn());
		}
		
		return casteCategoryRepository.save(casteCategory);
	}

	@Override
	public CasteCategory getCasteCategoryById(Long id) {
		// TODO Auto-generated method stub
		return casteCategoryRepository.findById(id).orElseThrow(()-> new RuntimeException("CasteCategory not found with ID: "+id));
	}

	@Override
	public List<CasteCategory> getAllCasteCategory(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return casteCategoryRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return casteCategoryRepository.findAll();
			
		}
		
	}

	@Override
	public CasteCategory deleteCasteCategory(Long id) {
		// TODO Auto-generated method stub
		CasteCategory casteCategory=getCasteCategoryById(id);
		casteCategory.setActive(false);
		casteCategory.setDeleted(true);
		return casteCategoryRepository.save(casteCategory);
	}

}
