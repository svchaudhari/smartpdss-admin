package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.District;
import com.spds.admin.repository.DistrictRepository;
import com.spds.admin.service.DistrictService;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
@Service
public class DistrictServiceImpl implements DistrictService{

	@Autowired
	private DistrictRepository districtRepo;
	
	@Override
	public District createUpdate(District district) {
		// TODO Auto-generated method stub
		Optional<District> st=districtRepo.findById(district.getId());
		if(st.isPresent()) {
			district.setCreatedBy(st.get().getCreatedBy());
			district.setCreatedOn(st.get().getCreatedOn());
		}
		return districtRepo.save(district);
	}

	@Override
	public District getDictrictById(Long id) {
		// TODO Auto-generated method stub
		return districtRepo.findById(id).orElseThrow(()-> new RuntimeException("District not fount with ID: "+id));
	}

	@Override
	public List<District> getAllDistrict(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return districtRepo.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return districtRepo.findAll();
			
		}
		
	}

	@Override
	public District deleteDistrict(Long id) {
		// TODO Auto-generated method stub
		District district=getDictrictById(id);
		district.setActive(false);
		district.setDeleted(true);
		return districtRepo.save(district);
	}

	@Override
	public List<District> getDistrictByStateId(Long stateId,Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return districtRepo.findByStateIdIsActiveIsTrueAndIsDeletedIsFalse(stateId);
		}else {
			return districtRepo.findByStateId(stateId);
		}
		
	}

	

}
