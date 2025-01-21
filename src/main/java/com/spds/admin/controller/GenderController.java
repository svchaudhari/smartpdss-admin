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
import com.spds.admin.entity.Gender;
import com.spds.admin.service.GenderService;
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
public class GenderController {

	@Autowired
	private GenderService genderService;
	
	@PostMapping("/gender/create-update")
	ResponseEntity<GenericResponse<Gender>> saveGender(@RequestBody Gender gender) throws Exception{
		try {
			Gender createdMapping = genderService.createUpdate(gender); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<Gender>(genderService.createUpdate(gender), HttpStatus.OK);
	}
	
	@GetMapping("/gender/get")
	ResponseEntity<GenericResponse<Gender>> getGender(@RequestParam Long id){
		try {
			Gender createdMapping = genderService.getGenderById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }  
		//return new ResponseEntity<Gender>(genderService.getGenderById(id),HttpStatus.OK);
	}
	
	@GetMapping("/gender/get-all")
	ResponseEntity<GenericResponse<List<Gender>>> getGender(@RequestParam Boolean isActive){
		try {
            List<Gender> mappings = genderService.getAllGender(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<List<Gender>>(genderService.getAllGender(isActive),HttpStatus.OK);
	}
	
	
	@GetMapping("/gender/delete")
	ResponseEntity<GenericResponse<Gender>> deleteGender(@RequestParam Long id){
		try {
			Gender createdMapping = genderService.deleteGender(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deletion Details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion Details-"+e.getMessage(), null, null));
        }  
		//return new ResponseEntity<Gender>(genderService.deleteGender(id),HttpStatus.OK);
	}
	
	
}
