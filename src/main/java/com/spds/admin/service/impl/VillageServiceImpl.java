package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.Village;
import com.spds.admin.repository.VillageRepository;
import com.spds.admin.service.VillageService;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Service
public class VillageServiceImpl implements VillageService{

	@Autowired
	private VillageRepository villageRepository;
	
	@Override
	public Village createUpdate(Village village) {
		// TODO Auto-generated method stub
		Optional<Village> st=villageRepository.findById(village.getId());
		if(st.isPresent()) {
			village.setCreatedBy(st.get().getCreatedBy());
			village.setCreatedOn(st.get().getCreatedOn());
		}
		return villageRepository.save(village);
	}

	@Override
	public Village getVillageById(Long id) {
		// TODO Auto-generated method stub
		return villageRepository.findById(id).orElseThrow(()-> new RuntimeException("Village not found with ID: "+id));
	}

	@Override
	public List<Village> getAllVillage(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return villageRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return villageRepository.findAll();
			
		}
		
	}

	@Override
	public Village deleteVillage(Long id) {
		// TODO Auto-generated method stub
		Village village=getVillageById(id);
		village.setActive(false);
		village.setDeleted(true);
		return villageRepository.save(village);
	}

	@Override
	public List<Village> getVillageById(Long id,Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return villageRepository.findByIdIsActiveIsTrueAndIsDeletedIsFalse(id);
		}else {
			return villageRepository.findAllById(id);
		}
		
	}

	

}
