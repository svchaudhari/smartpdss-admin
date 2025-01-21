package com.spds.admin.controller;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.BranchMaster;
import com.spds.admin.entity.DepotMaster;
import com.spds.admin.service.DepotMasterService;
import feign.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@RestController
@RequestMapping("/api/v1/depot/")
@Slf4j
public class DepotMasterController {

    @Autowired
    private DepotMasterService depotMasterService;

    @PostMapping("create-update")
    public ResponseEntity<GenericResponse<DepotMaster>> createOrUpdate(@RequestBody DepotMaster depotMaster) {
    	try {
    		DepotMaster createdMapping = depotMasterService.saveOrUpdateDepotDetails(depotMaster); 
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Depot details saved successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in saving Depot details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving Depot details-"+e.getMessage(), null, null));
        }
    	//return ResponseEntity.ok(this.depotMasterService.saveOrUpdateDepotDetails(depotMaster));
    }

    @GetMapping("get")
    public ResponseEntity<GenericResponse<DepotMaster>> getDepotDetailsById(@RequestParam Long id){
    	try {
    		DepotMaster createdMapping = depotMasterService.getDepotDetailsById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Depot details fetched successfully", createdMapping));
        } catch (Exception e) {
        	log.error("Error in fetching Depot details for depot id-"+id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching Depot details-"+e.getMessage(), null, null));
        }  
    	//return ResponseEntity.ok(this.depotMasterService.getDepotDetailsById(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<GenericResponse<List<DepotMaster>>> getAllDepotDetails(){
    	try {
            List<DepotMaster> mappings = depotMasterService.getAllDepot();
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Depot details fetched successfully", mappings));
        } catch (Exception e) {
        	log.error("Error in getching all Depot Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching Depot details-"+e.getMessage(), null, null));
        }
    	//return ResponseEntity.ok(this.depotMasterService.getAllDepot());
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteDepotDetailsById(@RequestParam Long id){
        return ResponseEntity.ok(this.depotMasterService.deleteDepotById(id));
    }
}
