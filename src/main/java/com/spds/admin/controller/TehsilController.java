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
import com.spds.admin.entity.Tehsil;
import com.spds.admin.service.TehsilService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class TehsilController {
	
	@Autowired
    private TehsilService tehsilService;

    
    @PostMapping("/tehsil/create-update")
    public ResponseEntity<GenericResponse<Tehsil>> saveTehsil(@RequestBody Tehsil tehsil) {
    	try {
    		Tehsil createdMapping = tehsilService.saveTehsil(tehsil); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
    	//return new ResponseEntity<Tehsil>(tehsilService.saveTehsil(tehsil),HttpStatus.OK);
    }
    
    @GetMapping("/tehsil/get-all")
    public ResponseEntity<GenericResponse<List<Tehsil>>> getAllTehsils(@RequestParam Boolean isActive) {
    	try {
            List<Tehsil> mappings = tehsilService.getAllTehsils(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-"+e.getMessage(), null, null));
        } 
    	//return new ResponseEntity<List<Tehsil>>(tehsilService.getAllTehsils(isActive),HttpStatus.OK);

    }

    @GetMapping("/tehsil/get")
    public ResponseEntity<GenericResponse<Tehsil>> getTehsilById(@RequestParam Long id) {
    	try {
    		Tehsil createdMapping = tehsilService.getTehsilById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }
    	//return new ResponseEntity<Tehsil>(tehsilService.getTehsilById(id),HttpStatus.OK);
    }

    @DeleteMapping("/tehsil/delete")
    public ResponseEntity<GenericResponse<Tehsil>> deleteBranchMaster(@RequestParam Long id) {
    	try {
    		Tehsil createdMapping = tehsilService.deleteById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deletion Details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion Details-"+e.getMessage(), null, null));
        }  
    }
    

}
