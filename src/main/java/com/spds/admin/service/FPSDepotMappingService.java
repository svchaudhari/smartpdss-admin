package com.spds.admin.service;

import com.spds.admin.entity.FPSDepotMapping;

import java.util.List;

public interface FPSDepotMappingService {
    FPSDepotMapping createFPSDepotMapping(FPSDepotMapping fpsDepotMapping);

    FPSDepotMapping getFPSDepotMappingById(Long id);

    FPSDepotMapping updateFPSDepotMapping(Long id, FPSDepotMapping fpsDepotMapping);

    List<FPSDepotMapping> getAllFPSDepotMappings();

    void deleteFPSDepotMapping(Long id);
}
