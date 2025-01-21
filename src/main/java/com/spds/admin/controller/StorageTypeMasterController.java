package com.spds.admin.controller;


import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.StorageTypeMaster;
import com.spds.admin.service.StorageTypeMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@RestController
@RequestMapping("/api/v1/storageType/")
@Slf4j
public class StorageTypeMasterController {

    @Autowired
    public StorageTypeMasterService storageTypeMasterService;

    @PostMapping("create-update")
    public ResponseEntity<GenericResponse<StorageTypeMaster>> createOrUpdateStorageType(@RequestBody StorageTypeMaster storageTypeMaster) {
        try {
            StorageTypeMaster createdMapping = storageTypeMasterService.saveOrUpdateStorageType(storageTypeMaster);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", createdMapping));
        } catch (Exception e) {
            log.error("Error in saving details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in saving details-" + e.getMessage(), null, null));
        }
        //return ResponseEntity.ok(this.storageTypeMasterService.saveOrUpdateStorageType(storageTypeMaster));
    }

    @GetMapping("get")
    public ResponseEntity<GenericResponse<StorageTypeMaster>> getStorageTypeById(@RequestParam Long id) {
        try {
            StorageTypeMaster createdMapping = storageTypeMasterService.getStorageTypeById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", createdMapping));
        } catch (Exception e) {
            log.error("Error in fetching details for id-" + id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
        //return ResponseEntity.ok(this.storageTypeMasterService.getStorageTypeById(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<GenericResponse<List<StorageTypeMaster>>> getAllStorageType(@RequestParam(required = false , defaultValue = "true") Boolean isActive) {
        try {
            List<StorageTypeMaster> storageType = storageTypeMasterService.getAllStorageType(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", storageType));
        } catch (Exception e) {
            log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching all details-" + e.getMessage(), null, null));
        }
        //return ResponseEntity.ok(this.storageTypeMasterService.getAllStorageType());
    }

    @DeleteMapping("delete")
    public ResponseEntity<GenericResponse<StorageTypeMaster>> deleteStorageTypeById(@RequestParam Long id) {
        return ResponseEntity.ok(this.storageTypeMasterService.deleteStorageTypeById(id));
    }

}
