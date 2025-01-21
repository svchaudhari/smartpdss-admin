package com.spds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spds.admin.entity.State;
import com.spds.admin.service.MasterLangGeneratorService;
import com.spds.admin.service.StateService;
import com.spds.admin.dto.GenericResponse;
import com.spds.admin.dto.UserPrincipal;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class StateController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private MasterLangGeneratorService masterLangService;
	
	@PostMapping("/state/create-update")
	ResponseEntity<GenericResponse<State>> saveState(@AuthenticationPrincipal UserPrincipal user , @RequestBody State state) throws Exception{
		
		try {
		State stateDetails=stateService.createState(state);
		
	        GenericResponse<State> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "State details saved successfully",  
	            stateDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch(Exception e) {
	        GenericResponse<State> response = new GenericResponse<>(
	            true,                
	            "Error in saving State Details", 
	            "",                  
	            null                 
	        );
	        log.error("Error in saving State Details ", e.getMessage(), e);
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
	    }
		
	}
	
	@GetMapping("/state/get")
	ResponseEntity<GenericResponse<State>> getState(@RequestParam Long id) throws Exception{
		try {
		State stateDetails=stateService.getStateById(id);
		
	        GenericResponse<State> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "State details fetched successfully",  
	            stateDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch(Exception e) {
	        GenericResponse<State> response = new GenericResponse<>(
	            true,                
	            "Error fetching State", 
	            "",                  
	            null                 
	        );
	        log.error("Error in fetching State Details for state id:-"+id, e.getMessage(), e);
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
	    }
		
		//return new ResponseEntity<State>(, HttpStatus.OK);
		
	}
	
	@GetMapping("/state/get-all")
	ResponseEntity<GenericResponse<List<State>>> getAllState(@RequestParam(required = false ,defaultValue = "true") Boolean isActive) throws Exception{
		try {
		List<State> stateDetails=stateService.getAllState(isActive);
		
	        GenericResponse<List<State>> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "State details fetched successfully",  
	            stateDetails      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch(Exception e) {
	        GenericResponse<List<State>> response = new GenericResponse<>(
	            true,                
	            "Error fetching State details", 
	            "",                  
	            null                 
	        );
	        log.error("Error in fetching All State Details ", e.getMessage(), e);
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
	    }
		
		
		//return new ResponseEntity<List<State>>(, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/state/delete")
	ResponseEntity<GenericResponse<State>> deleteState(@RequestParam Long id) throws Exception{
		try {
		State stateDetails=stateService.deleteState(id);
	        GenericResponse<State> response = new GenericResponse<>(
	            false,               
	            "",                  
	            "State deleted successfully",  
	            null      
	        );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch(Exception e) {
	        GenericResponse<State> response = new GenericResponse<>(
	            true,                
	            "Error deletion State details", 
	            "",                  
	            null                 
	        );
	        log.error("Error in deletion State Details for state id:-"+id, e.getMessage(), e);
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
	    }
		
		//return new ResponseEntity<State>(, HttpStatus.OK);
		
	}
	
}
