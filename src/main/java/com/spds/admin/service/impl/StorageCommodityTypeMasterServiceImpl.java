package com.spds.admin.service.impl;

import com.spds.admin.constant.AppConst;
import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.StorageCommodityTypeMaster;
import com.spds.admin.entity.StorageTypeMaster;
import com.spds.admin.repository.StorageCommodityTypeMasterRepository;
import com.spds.admin.service.StorageCommodityTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@Service
public class StorageCommodityTypeMasterServiceImpl implements StorageCommodityTypeMasterService {

    public static final String DELETE_STORAGE_COMMODITY_TYPE = "Storage commodity type  delete successfully.";

    @Autowired
    private StorageCommodityTypeMasterRepository storageCommodityTypeMasterRepository;

    @Override
    public StorageCommodityTypeMaster saveOrUpdateStorageCommodityType(StorageCommodityTypeMaster storageCommodityTypeMaster) {
    	Optional<StorageCommodityTypeMaster> st=storageCommodityTypeMasterRepository.findById(storageCommodityTypeMaster.getId());
		if(st.isPresent()) {
			storageCommodityTypeMaster.setCreatedBy(st.get().getCreatedBy());
			storageCommodityTypeMaster.setCreatedOn(st.get().getCreatedOn());
		}
        return this.storageCommodityTypeMasterRepository.save(storageCommodityTypeMaster);
    }

    @Override
    public StorageCommodityTypeMaster getStorageCommodityTypeById(Long id) {
        return this.storageCommodityTypeMasterRepository.findByIdAndIsDeletedFalseAndIsActiveTrue(id).orElseThrow(() -> new NoSuchElementException(AppConst.Message.Error.STORAGE_COMMODITY_DETAILS_NOT_FOUND));
    }

    @Override
    public List<StorageCommodityTypeMaster> getAllStorageCommodityType() {
        List<StorageCommodityTypeMaster> listOfCommodityType = this.storageCommodityTypeMasterRepository.findAll();
        if(listOfCommodityType.isEmpty()){
            throw new NullPointerException(AppConst.Message.Error.STORAGE_COMMODITY_DETAILS_NOT_FOUND);
        }
        return listOfCommodityType;
    }

    @Override
    public GenericResponse deleteStorageCommodityTypeById(Long id) {
        Optional<StorageCommodityTypeMaster> storageCommodityTypeDetails = this.storageCommodityTypeMasterRepository.findByIdAndIsDeletedFalseAndIsActiveTrue(id);
        if(storageCommodityTypeDetails.isEmpty()){
            return new GenericResponse(true,AppConst.Message.Error.STORAGE_DETAILS_NOT_FOUND,null ,storageCommodityTypeDetails);
        }
        storageCommodityTypeDetails.get().setActive(false);
        storageCommodityTypeDetails.get().setDeleted(true);
        StorageCommodityTypeMaster deletedStorageCommodityTypeDetails = this.storageCommodityTypeMasterRepository.save(storageCommodityTypeDetails.get());
        return new GenericResponse(false,null, DELETE_STORAGE_COMMODITY_TYPE, deletedStorageCommodityTypeDetails);
    }
}
