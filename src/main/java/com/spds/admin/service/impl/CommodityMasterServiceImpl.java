package com.spds.admin.service.impl;

import com.spds.admin.entity.CommodityMaster;
import com.spds.admin.repository.CommodityMasterRepository;
import com.spds.admin.service.CommodityMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommodityMasterServiceImpl implements CommodityMasterService {

    @Autowired
    private CommodityMasterRepository commodityMasterRepository;

    public CommodityMasterServiceImpl(CommodityMasterRepository commodityMasterRepository) {
        this.commodityMasterRepository = commodityMasterRepository;
    }

    @Override
    public CommodityMaster createCommodityMaster(CommodityMaster commodityMaster) {
    	Optional<CommodityMaster> st=commodityMasterRepository.findById(commodityMaster.getId());
		if(st.isPresent()) {
			commodityMaster.setCreatedBy(st.get().getCreatedBy());
			commodityMaster.setCreatedOn(st.get().getCreatedOn());
		}
    	
        return commodityMasterRepository.save(commodityMaster);
    }

    @Override
    public CommodityMaster getCommodityMasterById(Long id) {
        Optional<CommodityMaster> commodityMasterOptional = commodityMasterRepository.findById(id);
        if (commodityMasterOptional.isEmpty()) {
            throw new RuntimeException("Commodity not found with ID: " + id);
        }
        return commodityMasterOptional.get();
    }

    @Override
    public CommodityMaster updateCommodityMaster(Long id, CommodityMaster commodityMaster) {
        CommodityMaster existingCommodity = getCommodityMasterById(id);

        // Update the fields
        existingCommodity.setCommodityName(commodityMaster.getCommodityName());

        return commodityMasterRepository.save(existingCommodity);
    }

    @Override
    public void deleteCommodityMaster(Long id) {
        CommodityMaster existingCommodity = getCommodityMasterById(id);
        commodityMasterRepository.delete(existingCommodity);

    }

    @Override
    public List<CommodityMaster> getAllCommodityMasters() {
        return commodityMasterRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
    }
}
