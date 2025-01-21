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
import com.spds.admin.entity.CasteCategory;
import com.spds.admin.entity.District;
import com.spds.admin.service.CasteCategoryService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CasteCategoryController {

	@Autowired
	private CasteCategoryService casteCategoryService;
	
	@PostMapping("/casteCategory/create-update")
	ResponseEntity<GenericResponse<CasteCategory>> saveCasteCategory(@RequestBody CasteCategory casteCategory) throws Exception{
		try {
			CasteCategory createdMapping = casteCategoryService.createUpdate(casteCategory); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
	}
	
	@GetMapping("/casteCategory/get")
	ResponseEntity<GenericResponse<CasteCategory>> getCasteCategory(@RequestParam Long id){
		try {
			CasteCategory createdMapping = casteCategoryService.getCasteCategoryById(id); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details"+e.getMessage(), null, null));
        } 
	}
	
	@GetMapping("/casteCategory/get-all")
	ResponseEntity<GenericResponse<List<CasteCategory>>> getCasteCategory(@RequestParam Boolean isActive){
		try {
			List<CasteCategory> createdMapping = casteCategoryService.getAllCasteCategory(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        } 
	}
	
	
	@GetMapping("/casteCategory/delete")
	ResponseEntity<GenericResponse<CasteCategory>> deleteCasteCategory(@RequestParam Long id){
		try {
			CasteCategory createdMapping = casteCategoryService.deleteCasteCategory(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deleting details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in deleting details-"+e.getMessage(), null, null));
        }
	}
	
	
}
