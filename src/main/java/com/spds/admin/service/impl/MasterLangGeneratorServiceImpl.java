package com.spds.admin.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.MasterLangGenerator;
import com.spds.admin.repository.MasterLangGeneratorRepository;
import com.spds.admin.service.MasterLangGeneratorService;

@Service
public class MasterLangGeneratorServiceImpl implements MasterLangGeneratorService{

	@Autowired
	private MasterLangGeneratorRepository masterLangRepo;
	
	@Override
	public MasterLangGenerator createMasterLangGen(MasterLangGenerator mlg) {
		// TODO Auto-generated method stub
		Optional<MasterLangGenerator> st=masterLangRepo.findById(mlg.getId());
		if(st.isPresent()) {
			mlg.setCreatedBy(st.get().getCreatedBy());
			mlg.setCreatedOn(st.get().getCreatedOn());
		}
		return masterLangRepo.save(mlg);
	}

	@Override
	public MasterLangGenerator getMasterLangGen(String refType, String langType, Long stateId) {
		// TODO Auto-generated method stub
		return masterLangRepo.findByStateId(stateId,langType,refType);
	}

	/**@Override
	public MasterLangGenerator getMasterLangGen(String refType, String langType, Long stateId) {
		MasterLangGenerator masterLangGenerator = masterLangRepo.findByStateId(stateId);
        return masterLangGenerator.getRefType();
	}
	
	@Override
	public MasterLangGenerator getMasterLangGen(String refType, String langType, Long stateId) {
		MasterLangGenerator masterLangGenerator = masterLangRepo.findByStateId(stateId);
        String ref=masterLangGenerator.getRefType();
        
	}**/

}
