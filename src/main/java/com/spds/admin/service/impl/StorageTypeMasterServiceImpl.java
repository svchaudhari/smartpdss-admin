package com.spds.admin.service.impl;

import com.spds.admin.constant.AppConst;
import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.StorageTypeMaster;
import com.spds.admin.repository.StorageTypeMasterRepository;
import com.spds.admin.service.StorageTypeMasterService;
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
public class StorageTypeMasterServiceImpl implements StorageTypeMasterService {

    public static final String DELETE_STORAGE_TYPE = "Storage type  delete successfully.";

    @Autowired
    private StorageTypeMasterRepository storageTypeMasterRepository;

    @Override
    public StorageTypeMaster saveOrUpdateStorageType(StorageTypeMaster storageTypeMaster) {
    	Optional<StorageTypeMaster> st=storageTypeMasterRepository.findById(storageTypeMaster.getId());
		if(st.isPresent()) {
			storageTypeMaster.setCreatedBy(st.get().getCreatedBy());
			storageTypeMaster.setCreatedOn(st.get().getCreatedOn());
		}
        return this.storageTypeMasterRepository.save(storageTypeMaster);
    }

    @Override
    public StorageTypeMaster getStorageTypeById(Long id) {
        return this.storageTypeMasterRepository.findByIdAndIsDeletedFalseAndIsActiveTrue(id).orElseThrow(() -> new NoSuchElementException(AppConst.Message.Error.STORAGE_DETAILS_NOT_FOUND));

    }

    @Override
    public List<StorageTypeMaster> getAllStorageType(Boolean isActive) {
    	
        if (isActive == null || isActive==true) {
        	return this.storageTypeMasterRepository.findAllByIsDeletedFalseAndIsActiveTrue();
        } else {
        	return this.storageTypeMasterRepository.findAllByIsDeletedFalse();
        }
    }

    @Override
    public GenericResponse deleteStorageTypeById(Long id) {
        Optional<StorageTypeMaster> storageTypeDetails = this.storageTypeMasterRepository.findByIdAndIsDeletedFalseAndIsActiveTrue(id);
        if(storageTypeDetails.isEmpty()){
            return new GenericResponse(true,AppConst.Message.Error.STORAGE_DETAILS_NOT_FOUND,null ,storageTypeDetails);
        }
        storageTypeDetails.get().setActive(false);
        storageTypeDetails.get().setDeleted(true);
        StorageTypeMaster deletedStorageTypeDetails = this.storageTypeMasterRepository.save(storageTypeDetails.get());
        return new GenericResponse(false,null, DELETE_STORAGE_TYPE, deletedStorageTypeDetails);
    }
}
