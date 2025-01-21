package com.spds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.spds.admin.entity.Village;
import com.spds.admin.service.VillageService;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class VillageController {

	@Autowired
	private VillageService villageService;
	
	@PostMapping("/village/create-update")
	ResponseEntity<GenericResponse<Village>> saveVillage(@RequestBody Village village) throws Exception{
		try {
			Village createdMapping = villageService.createUpdate(village); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<Village>(villageService.createUpdate(village), HttpStatus.OK);
	}
	
	@GetMapping("/village/get")
	ResponseEntity<GenericResponse<Village>> getVillage(@RequestParam Long id){
		try {
			Village createdMapping = villageService.getVillageById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<Village>(villageService.getVillageById(id),HttpStatus.OK);
	}
	
	@GetMapping("/village/get-all")
	ResponseEntity<GenericResponse<List<Village>>> getVillage(@RequestParam Boolean isActive){
		try {
            List<Village> mappings = villageService.getAllVillage(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<List<Village>>(villageService.getAllVillage(isActive),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/village/delete")
	ResponseEntity<GenericResponse<Village>> deleteVillage(@RequestParam Long id){
		try {
			Village createdMapping = villageService.deleteVillage(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deletion Details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion Details-"+e.getMessage(), null, null));
        }  
		//return new ResponseEntity<Village>(villageService.deleteVillage(id),HttpStatus.OK);
	}
	
	@GetMapping("/village/get-by-id")
	ResponseEntity<GenericResponse<List<Village>>> getVillageByTehsilId(@RequestParam Long tehsilId,@RequestParam Boolean isActive){
		try {
            List<Village> mappings = villageService.getVillageById(tehsilId,isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details by Id fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching Details by Id-"+tehsilId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details by Id-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<List<Village>>(villageService.getVillageById(tehsilId,isActive),HttpStatus.OK);
	}
	
	public HttpHeaders generateHeader() {
	HttpHeaders headers = new HttpHeaders();
    headers.add("X-Custom-Header", "SomeValue");
    //headers.add("X-Error-Message", ex.getMessage());
	return headers;
	}
}
