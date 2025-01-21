package com.spds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.BranchMaster;
import com.spds.admin.entity.StateCategory;
import com.spds.admin.service.StateCategoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class StateCategoryController {

	@Autowired
	private StateCategoryService stateCategoryService;
	
	@PostMapping("/statecategory/create-update")
	ResponseEntity<GenericResponse<StateCategory>> saveState(@RequestBody StateCategory state) throws Exception{
		try {
			StateCategory createdMapping = stateCategoryService.createState(state); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<StateCategory>(stateCategoryService.createState(state), HttpStatus.OK);
		
	}
	
	@GetMapping("/statecategory/get")
	ResponseEntity<GenericResponse<StateCategory>> getState(@RequestParam Long id) throws Exception{
		try {
			StateCategory createdMapping = stateCategoryService.getStateSchemeById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        } 
		//return new ResponseEntity<StateCategory>(stateCategoryService.getStateSchemeById(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/statecategory/get-all")
	ResponseEntity<GenericResponse<List<StateCategory>>> getAllState(@RequestParam Boolean isActive) throws Exception{
		try {
            List<StateCategory> mappings = stateCategoryService.getAllStateScheme(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<List<StateCategory>>(stateCategoryService.getAllStateScheme(isActive), HttpStatus.OK);
		
	}
	 
	
	@DeleteMapping("/statecategory/delete")
	ResponseEntity<GenericResponse<StateCategory>> deleteState(@RequestParam Long id) throws Exception{
		try {
			StateCategory createdMapping = stateCategoryService.deleteStateScheme(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deletion Details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion Details-"+e.getMessage(), null, null));
        } 
		//return new ResponseEntity<StateCategory>(stateCategoryService.deleteStateScheme(id), HttpStatus.OK);
		
	}
}
