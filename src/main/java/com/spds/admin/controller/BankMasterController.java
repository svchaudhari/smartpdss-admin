package com.spds.admin.controller;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.BankMaster;
import com.spds.admin.entity.FPSDepotMapping;
import com.spds.admin.entity.State;
import com.spds.admin.service.BankMasterService;
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
public class BankMasterController {

    @Autowired
    private BankMasterService bankMasterService;

    @PostMapping("/bankMaster/create-update")
    public ResponseEntity<GenericResponse<BankMaster>> createUpdateBankMaster(@RequestBody BankMaster bankMaster) {
    	try {
    		BankMaster createdMapping = bankMasterService.createUpdate(bankMaster);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-"+e.getMessage(), null, null));
        }
    	//return new ResponseEntity<>(bankMasterService.createUpdate(bankMaster), HttpStatus.OK);
    }

    @GetMapping("/bankMaster/get")
    public ResponseEntity<GenericResponse<BankMaster>> getBankMaster(@RequestParam Long id) {
    	try {
    		BankMaster createdMapping = bankMasterService.getById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Setails fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching Details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-"+e.getMessage(), null, null));
        }  
	}
    
    @GetMapping("/bankMaster/get-all")
    public ResponseEntity<GenericResponse<List<BankMaster>>> getAllBankMaster(@RequestParam Boolean isActive) {
    	try {
            List<BankMaster> mappings = bankMasterService.getAll(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details-"+e.getMessage(), null, null));
        }
    }

    @DeleteMapping("/bankMaster/delete")
    public ResponseEntity<GenericResponse<BankMaster>> deleteBankMaster(@RequestParam Long id) {
    	try {
    		BankMaster createdMapping = bankMasterService.deleteById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Deleted successfully", null));
        } catch (Exception e) {
        	log.error("Error deletion details for id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error deletion details-"+e.getMessage(), null, null));
        }  
    }

}
