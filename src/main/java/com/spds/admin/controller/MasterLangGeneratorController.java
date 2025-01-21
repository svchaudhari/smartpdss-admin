package com.spds.admin.controller;

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
import com.spds.admin.entity.District;
import com.spds.admin.entity.MasterLangGenerator;
import com.spds.admin.service.MasterLangGeneratorService;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 *@author mohdksiddiqui
 *created 24 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j

public class MasterLangGeneratorController {
	
	@Autowired
	private MasterLangGeneratorService masterLangService;
	
	@PostMapping("/state/create-master-lang")
	ResponseEntity<GenericResponse<MasterLangGenerator>> saveMasterLangGen(@RequestBody MasterLangGenerator mlg){
		try {
			MasterLangGenerator createdMapping = masterLangService.createMasterLangGen(mlg);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
		
		//return new ResponseEntity<MasterLangGenerator>(masterLangService.createMasterLangGen(mlg),HttpStatus.OK);
	}
	
	@GetMapping("/state/get-master-lang")
	ResponseEntity<GenericResponse<MasterLangGenerator>> getMasterLangGen(@RequestParam String refType, 
	                                  @RequestParam String langType, 
	                                  @RequestParam Long stateId) {
		
		try {
			MasterLangGenerator createdMapping = masterLangService.getMasterLangGen(refType,langType,stateId);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for Id-"+refType+"-"+langType+"-"+stateId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details"+e.getMessage(), null, null));
        } 
		//return new ResponseEntity<MasterLangGenerator>(masterLangService.getMasterLangGen(refType,langType,stateId),HttpStatus.OK);
	}

}
