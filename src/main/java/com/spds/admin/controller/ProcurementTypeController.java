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
import com.spds.admin.entity.ProcurementType;
import com.spds.admin.service.ProcurementTypeService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ProcurementTypeController {

	@Autowired
	private ProcurementTypeService procurementTypeService;
	
	@PostMapping("/procurementtype/create-update")
	ResponseEntity<GenericResponse<ProcurementType>> saveState(@RequestBody ProcurementType state) throws Exception{
		try {
			ProcurementType createdMapping = procurementTypeService.createState(state); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<ProcurementType>(procurementTypeService.createState(state), HttpStatus.OK);
		
	}
	
	@GetMapping("/procurementtype/get")
	ResponseEntity<GenericResponse<ProcurementType>> getState(@RequestParam Long id) throws Exception{
		try {
			ProcurementType createdMapping = procurementTypeService.getProcurmentTypeById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        } 
		//return new ResponseEntity<ProcurementType>(procurementTypeService.getProcurmentTypeById(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/procurementtype/get-all")
	ResponseEntity<GenericResponse<List<ProcurementType>>> getAllState(@RequestParam Boolean isActive) throws Exception{
		try {
            List<ProcurementType> mappings = procurementTypeService.getAllProcurementType(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-"+e.getMessage(), null, null));
        }
		//return new ResponseEntity<List<ProcurementType>>(procurementTypeService.getAllProcurementType(isActive), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/procurementtype/delete")
	ResponseEntity<GenericResponse<ProcurementType>> deleteState(@RequestParam Long id) throws Exception{
		try {
			ProcurementType createdMapping = procurementTypeService.deleteProcurementType(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deletion Details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion Details-"+e.getMessage(), null, null));
        } 
		//return new ResponseEntity<ProcurementType>(procurementTypeService.deleteProcurementType(id), HttpStatus.OK);
		
	}
}
