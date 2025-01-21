package com.spds.admin.controller;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.FPSDepotMapping;
import com.spds.admin.service.FPSDepotMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fps-depot-mapping")
@Slf4j
public class FPSDepotMappingController {

    @Autowired
    private FPSDepotMappingService fpsDepotMappingService;

    public FPSDepotMappingController(FPSDepotMappingService fpsDepotMappingService) {
        this.fpsDepotMappingService = fpsDepotMappingService;


    }


    @PostMapping("/create/fps-depot-mapping")
    public ResponseEntity<GenericResponse<FPSDepotMapping>> createFPSDepotMapping(@RequestBody FPSDepotMapping fpsDepotMapping) {
        try {
            FPSDepotMapping createdMapping = fpsDepotMappingService.createFPSDepotMapping(fpsDepotMapping);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "FPS Depot Mapping created successfully", createdMapping));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<FPSDepotMapping>> getFPSDepotMappingById(@PathVariable Long id) {
        try {
            FPSDepotMapping fpsDepotMapping = fpsDepotMappingService.getFPSDepotMappingById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "FPS Depot Mapping fetched successfully", fpsDepotMapping));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<FPSDepotMapping>> updateFPSDepotMapping(@PathVariable Long id, @RequestBody FPSDepotMapping fpsDepotMapping) {
        try {
            FPSDepotMapping updatedMapping = fpsDepotMappingService.updateFPSDepotMapping(id, fpsDepotMapping);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "FPS Depot Mapping updated successfully", updatedMapping));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @GetMapping("/get-all/fps-depot-mapping")
    public ResponseEntity<GenericResponse<List<FPSDepotMapping>>> getAllFPSDepotMappings() {
        try {
            List<FPSDepotMapping> mappings = fpsDepotMappingService.getAllFPSDepotMappings();
            return ResponseEntity.ok(new GenericResponse<>(false, null, "All FPS Depot Mappings fetched successfully", mappings));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteFPSDepotMapping(@PathVariable Long id) {
        try {
            fpsDepotMappingService.deleteFPSDepotMapping(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "FPS Depot Mapping deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }


}
