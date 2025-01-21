package com.spds.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.MasterLangGenerator;
import com.spds.admin.entity.User;
import com.spds.admin.service.NewRegistrationService;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 02 Jan 2025
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class NewRegistrationController{

	@Autowired
	private NewRegistrationService newRegistrationService;
	
	@PostMapping("/user/pre-registration")
	ResponseEntity<GenericResponse<User>> saveDistrict(@RequestBody User user, @RequestParam long invitationId) throws Exception{
		try {
			User createdMapping = newRegistrationService.createUpdate(user,invitationId);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
	}
	
}
