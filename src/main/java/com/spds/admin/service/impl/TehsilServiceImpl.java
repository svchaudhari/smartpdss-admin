package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.BranchMaster;
import com.spds.admin.entity.State;
import com.spds.admin.entity.Tehsil;
import com.spds.admin.repository.TehsilRepository;
import com.spds.admin.service.TehsilService;

@Service
public class TehsilServiceImpl implements TehsilService {

    @Autowired
    private TehsilRepository tehsilRepository;

    @Override
    public Tehsil saveTehsil(Tehsil tehsil) {
    	Optional<Tehsil> st=tehsilRepository.findById(tehsil.getId());
		if(st.isPresent()) {
			tehsil.setCreatedBy(st.get().getCreatedBy());
			tehsil.setCreatedOn(st.get().getCreatedOn());
		}
        return tehsilRepository.save(tehsil);
    }
    
    @Override
	public List<Tehsil> getAllTehsils(Boolean isActive) {
		if(isActive==true) {
			return tehsilRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return tehsilRepository.findAll();
			
		}
		
	}

    @Override
	public Tehsil getTehsilById(Long id) {
	    return tehsilRepository.findById(id).orElseThrow(()-> new RuntimeException("Tehsil not fount with ID: "+id));
	}

	@Override
	public Tehsil deleteById(Long id) {
		Tehsil state=getTehsilById(id);
		state.setActive(false);
		state.setDeleted(true);
		return tehsilRepository.save(state);
	}


   
}
