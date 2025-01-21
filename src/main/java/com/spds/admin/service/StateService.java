package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.State;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
public interface StateService {

	State createState(State state);
	State getStateById(Long id);
	List<State> getAllState(Boolean isActive);
	State deleteState(Long id);

}
