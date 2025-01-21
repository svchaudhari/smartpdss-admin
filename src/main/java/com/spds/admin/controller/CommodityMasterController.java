package com.spds.admin.controller;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.CommodityMaster;
import com.spds.admin.service.CommodityMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commodity-masters")
@Slf4j
public class CommodityMasterController {
    @Autowired
    private CommodityMasterService commodityMasterService;

    public CommodityMasterController(CommodityMasterService commodityMasterService) {
        this.commodityMasterService = commodityMasterService;
    }

    @PostMapping("/create-commodity")
    public ResponseEntity<GenericResponse<CommodityMaster>> createCommodityMaster(@RequestBody CommodityMaster commodityMaster) {
        try {
            CommodityMaster createdCommodity = commodityMasterService.createCommodityMaster(commodityMaster);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Commodity created successfully", createdCommodity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CommodityMaster>> getCommodityMasterById(@PathVariable Long id) {
        try {
            CommodityMaster commodityMaster = commodityMasterService.getCommodityMasterById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Commodity fetched successfully", commodityMaster));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CommodityMaster>> updateCommodityMaster(@PathVariable Long id, @RequestBody CommodityMaster commodityMaster) {
        try {
            CommodityMaster updatedCommodity = commodityMasterService.updateCommodityMaster(id, commodityMaster);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Commodity updated successfully", updatedCommodity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteCommodityMaster(@PathVariable Long id) {
        try {
            commodityMasterService.deleteCommodityMaster(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Commodity deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<GenericResponse<List<CommodityMaster>>> getAllCommodityMasters() {
        try {
            List<CommodityMaster> commodities = commodityMasterService.getAllCommodityMasters();
            return ResponseEntity.ok(new GenericResponse<>(false, null, "All commodities fetched successfully", commodities));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, e.getMessage(), null, null));
        }
    }
}
