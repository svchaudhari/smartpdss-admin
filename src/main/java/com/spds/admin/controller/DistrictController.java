package com.spds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.spds.admin.entity.District;
import com.spds.admin.entity.State;
import com.spds.admin.service.DistrictService;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class DistrictController {

	@Autowired
	private DistrictService districtService;
	
	@PostMapping("/district/create-update")
	ResponseEntity<GenericResponse<District>> saveDistrict(@RequestBody District distrcit) throws Exception{
		try {
			District createdMapping = districtService.createUpdate(distrcit); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<District>(districtService.createUpdate(distrcit), HttpStatus.OK);
	}
	
	@GetMapping("/district/get")
	ResponseEntity<GenericResponse<District>> getDistrict(@RequestParam Long id){
		try {
			District createdMapping = districtService.getDictrictById(id); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details"+e.getMessage(), null, null));
        } 
		
		//return new ResponseEntity<District>(districtService.getDictrictById(id),HttpStatus.OK);
	}
	
	@GetMapping("/district/get-all")
	ResponseEntity<GenericResponse<List<District>>> getDistrict(@RequestParam Boolean isActive){
		try {
			List<District> createdMapping = districtService.getAllDistrict(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }  
		//return new ResponseEntity<List<District>>(districtService.getAllDistrict(isActive),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/district/delete")
	ResponseEntity<GenericResponse<District>> deleteDistrict(@RequestParam Long id){
		try {
			District createdMapping = districtService.deleteDistrict(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deleting details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in deleting details-"+e.getMessage(), null, null));
        } 
		//return new ResponseEntity<District>(districtService.deleteDistrict(id),HttpStatus.OK);
	}
	
	@GetMapping
	("/district/get-by-stateid")
	ResponseEntity<GenericResponse<List<District>>> getDistrictByStateId(@RequestParam Long stateId,@RequestParam Boolean isActive){
		try {
            List<District> mappings = districtService.getDistrictByStateId(stateId,isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details by Id fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching Details by Id-"+stateId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details by Id-"+e.getMessage(), null, null));
        } 
		
		//return new ResponseEntity<List<District>>(districtService.getDistrictByStateId(stateId,isActive),HttpStatus.OK);
	}
}
