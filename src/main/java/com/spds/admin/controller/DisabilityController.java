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
import com.spds.admin.entity.Disability;
import com.spds.admin.entity.District;
import com.spds.admin.service.DisabilityService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class DisabilityController {

	@Autowired
	private DisabilityService disabilityService;
	
	@PostMapping("/disability/create-update")
	ResponseEntity<GenericResponse<Disability>> saveDisability(@RequestBody Disability disability) throws Exception{
		try {
			Disability createdMapping = disabilityService.createUpdate(disability); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
	}
	
	@GetMapping("/disability/get")
	ResponseEntity<GenericResponse<Disability>> getDisability(@RequestParam Long id){
		try {
			Disability createdMapping = disabilityService.getDisabilityById(id); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details"+e.getMessage(), null, null));
        } 
	}
	
	@GetMapping("/disability/get-all")
	ResponseEntity<GenericResponse<List<Disability>>> getDisability(@RequestParam Boolean isActive){
		try {
			List<Disability> createdMapping = disabilityService.getAllDisability(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        } 
	}
	
	
	@GetMapping("/disability/delete")
	ResponseEntity<GenericResponse<Disability>> deleteDisability(@RequestParam Long id){
		try {
			Disability createdMapping = disabilityService.deleteDisability(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deleting details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in deleting details-"+e.getMessage(), null, null));
        } 
	}
	
	@GetMapping("/disability/get-by-disabilityCode")
	ResponseEntity<GenericResponse<List<Disability>>> getVillageByTehsilCode(@RequestParam String disabilityCode,@RequestParam Boolean isActive){
		try {
            List<Disability> mappings = disabilityService.getDisabilityByDisabilityCode(disabilityCode,isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details by Id fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching Details by Id-"+disabilityCode, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details by Id-"+e.getMessage(), null, null));
        } 
		
	}
}
