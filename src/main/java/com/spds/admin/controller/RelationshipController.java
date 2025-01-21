package com.spds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.BranchMaster;
import com.spds.admin.entity.Relationship;
import com.spds.admin.service.RelationshipService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class RelationshipController {

	@Autowired
	private RelationshipService relationshipService;
	
	@PostMapping("/relationship/create-update")
	ResponseEntity<GenericResponse<Relationship>> saveVillage(@RequestBody Relationship relationship) throws Exception{
		try {
			Relationship createdMapping = relationshipService.createUpdate(relationship); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<Relationship>(relationshipService.createUpdate(relationship), HttpStatus.OK);
	}
	
	@GetMapping("/relationship/get")
	ResponseEntity<GenericResponse<Relationship>> getRelationship(@RequestParam Long id){
		try {
			Relationship createdMapping = relationshipService.getRelationshipById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }  
		//return new ResponseEntity<Relationship>(relationshipService.getRelationshipById(id),HttpStatus.OK);
	}
	
	@GetMapping("/relationship/get-all")
	ResponseEntity<GenericResponse<List<Relationship>>> getVillage(@RequestParam Boolean isActive){
		try {
            List<Relationship> mappings = relationshipService.getAllRelationship(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<List<Relationship>>(relationshipService.getAllRelationship(isActive),HttpStatus.OK);
	}
	
	
	@GetMapping("/relationship/delete")
	ResponseEntity<GenericResponse<Relationship>> deleteRelationship(@RequestParam Long id){
		try {
			Relationship createdMapping = relationshipService.deleteRelationship(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deletion Details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion Details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<Relationship>(relationshipService.deleteRelationship(id),HttpStatus.OK);
	}
	
	@GetMapping("/relationship/get-by-rscode")
	ResponseEntity<GenericResponse<List<Relationship>>> getRelationshipByTehsilCode(@RequestParam String rsCode,@RequestParam Boolean isActive){
		try {
            List<Relationship> mappings = relationshipService.getRelationshipByRsCode(rsCode,isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details by Id fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching Details by Id-"+rsCode, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details by Id-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<List<Relationship>>(relationshipService.getRelationshipByRsCode(rsCode,isActive),HttpStatus.OK);
	}
}
