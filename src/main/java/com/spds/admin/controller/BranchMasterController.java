package com.spds.admin.controller;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.BankMaster;
import com.spds.admin.entity.BranchMaster;
import com.spds.admin.service.BranchMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author muhammadtalib
 * created 27 Dec 2024
 */

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class BranchMasterController {

    @Autowired
    private BranchMasterService branchMasterService;

    @PostMapping("/branchMaster/create-update")
    public ResponseEntity<GenericResponse<BranchMaster>> createUpdateBranchMaster(@RequestBody BranchMaster branchMaster) {
    	try {
    		BranchMaster createdMapping = branchMasterService.createUpdate(branchMaster); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
    }

    @GetMapping("/branchMaster/get")
    public ResponseEntity<GenericResponse<BranchMaster>> getBranchMaster(@RequestParam Long id) {
    	try {
    		BranchMaster createdMapping = branchMasterService.getById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }  
    }

    @GetMapping("/branchMaster/get-all")
    public ResponseEntity<GenericResponse<List<BranchMaster>>> getAllBranchMaster(@RequestParam Boolean isActive) {
    	try {
            List<BranchMaster> mappings = branchMasterService.getAll(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-"+e.getMessage(), null, null));
        }
    }

    @DeleteMapping("/branchMaster/delete")
    public ResponseEntity<GenericResponse<BranchMaster>> deleteBranchMaster(@RequestParam Long id) {
    	try {
    		BranchMaster createdMapping = branchMasterService.deleteById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error in deletion Details for Id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion Details-"+e.getMessage(), null, null));
        }  
    }

    @GetMapping("/branchMaster/get-bank-id")
    public ResponseEntity<GenericResponse<List<BranchMaster>>> getAllBranchMasterByBankId(@RequestParam Long bankId) {
    	try {
            List<BranchMaster> mappings = branchMasterService.getAllByBankId(bankId);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details by Id fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching Details by Id-"+bankId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details by Id-"+e.getMessage(), null, null));
        }
    }
}
