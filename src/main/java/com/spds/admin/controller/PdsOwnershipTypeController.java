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
import com.spds.admin.entity.District;
import com.spds.admin.entity.PdsOwnershipType;
import com.spds.admin.service.PdsOwnershipTypeService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PdsOwnershipTypeController {

	@Autowired
	private PdsOwnershipTypeService pdsOwnershipService;
	
	@PostMapping("/pdsownership/create-update")
	ResponseEntity<GenericResponse<PdsOwnershipType>> saveState(@RequestBody PdsOwnershipType state) throws Exception{
		try {
			PdsOwnershipType createdMapping = pdsOwnershipService.createState(state); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
	}
	
	@GetMapping("/pdsownership/get")
	ResponseEntity<GenericResponse<PdsOwnershipType>> getState(@RequestParam Long id) throws Exception{
		try {
			PdsOwnershipType createdMapping = pdsOwnershipService.getPdsOwnershipById(id); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details"+e.getMessage(), null, null));
        } 
	}
	
	@GetMapping("/pdsownership/get-all")
	ResponseEntity<GenericResponse<List<PdsOwnershipType>>> getAllState(@RequestParam Boolean isActive) throws Exception{
		try {
			List<PdsOwnershipType> createdMapping = pdsOwnershipService.getAllPdsOwnership(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        } 
	}
	
	@DeleteMapping("/pdsownership/delete")
	ResponseEntity<GenericResponse<PdsOwnershipType>> deleteState(@RequestParam Long id) throws Exception{
		try {
			PdsOwnershipType createdMapping = pdsOwnershipService.deletePdsOwnership(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deleting details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in deleting details-"+e.getMessage(), null, null));
        } 
	}
}
