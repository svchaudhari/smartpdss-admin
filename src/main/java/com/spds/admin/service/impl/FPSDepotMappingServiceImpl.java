package com.spds.admin.service.impl;

import com.spds.admin.entity.FPSDepotMapping;
import com.spds.admin.repository.FPSDepotMappingRepository;
import com.spds.admin.service.FPSDepotMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FPSDepotMappingServiceImpl implements FPSDepotMappingService {

    @Autowired
    private FPSDepotMappingRepository fpsDepotMappingRepository;

    public FPSDepotMappingServiceImpl(FPSDepotMappingRepository fpsDepotMappingRepository) {
        this.fpsDepotMappingRepository = fpsDepotMappingRepository;
    }

    @Override
    public FPSDepotMapping createFPSDepotMapping(FPSDepotMapping fpsDepotMapping) {
    	Optional<FPSDepotMapping> st=fpsDepotMappingRepository.findById(fpsDepotMapping.getId());
		if(st.isPresent()) {
			fpsDepotMapping.setCreatedBy(st.get().getCreatedBy());
			fpsDepotMapping.setCreatedOn(st.get().getCreatedOn());
		}
        return fpsDepotMappingRepository.save(fpsDepotMapping);
    }

    @Override
    public FPSDepotMapping getFPSDepotMappingById(Long id) {
        Optional<FPSDepotMapping> fpsDepotMappingOptional = fpsDepotMappingRepository.findById(id);
        if (fpsDepotMappingOptional.isEmpty()) {
            throw new RuntimeException("FPS Depot Mapping not found with ID: " + id);
        }
        return fpsDepotMappingOptional.get();
    }

    @Override
    public FPSDepotMapping updateFPSDepotMapping(Long id, FPSDepotMapping fpsDepotMapping) {
        FPSDepotMapping existingMapping = getFPSDepotMappingById(id);

        // Update the fields
        existingMapping.setFpsId(fpsDepotMapping.getFpsId());
        existingMapping.setCommodityId(fpsDepotMapping.getCommodityId());
        existingMapping.setDistrictId(fpsDepotMapping.getDistrictId());
        existingMapping.setTransportDistance(fpsDepotMapping.getTransportDistance());
        existingMapping.setStatus(fpsDepotMapping.getStatus());
        existingMapping.setState_id(fpsDepotMapping.getState_id());

        return fpsDepotMappingRepository.save(existingMapping);
    }

    @Override
    public List<FPSDepotMapping> getAllFPSDepotMappings() {
        return fpsDepotMappingRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
    }

    @Override
    public void deleteFPSDepotMapping(Long id) {
        FPSDepotMapping existingMapping = getFPSDepotMappingById(id);
        fpsDepotMappingRepository.delete(existingMapping);
    }
}
