package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.State;
import com.spds.admin.repository.StateRepository;
import com.spds.admin.service.StateService;

import jakarta.persistence.EntityNotFoundException;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
@Service
public class StateServiceImpl implements StateService{
	
	@Autowired
	private StateRepository stateRepo;

	@Override
	public State createState(State state) {
		// TODO Auto-generated method stub
		Optional<State> st=stateRepo.findById(state.getId());
		if(st.isPresent()) {
			state.setCreatedBy(st.get().getCreatedBy());
			state.setCreatedOn(st.get().getCreatedOn());
		}
		return stateRepo.save(state);
	}

	@Override
	public State getStateById(Long id) {
		// TODO Auto-generated method stub
		return stateRepo.findById(id).orElseThrow(()->new EntityNotFoundException("State not found with ID: " + id));
	}

	@Override
	public List<State> getAllState(Boolean isActive) {
		// TODO Auto-generated method stub
		if (isActive == null || isActive == true) {
			return stateRepo.findAllByIsActiveIsTrue();
		} else {
			return stateRepo.findAllIsDeletedFalse();
		}
	}

	@Override
	public State deleteState(Long id) {
		// TODO Auto-generated method stub
		State state=getStateById(id);
		state.setActive(false);
		state.setDeleted(true);
		return stateRepo.save(state);
	}

	
	
	

}
