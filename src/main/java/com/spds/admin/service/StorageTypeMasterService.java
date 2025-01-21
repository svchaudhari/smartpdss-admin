package com.spds.admin.service;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.StorageTypeMaster;

import java.util.List;

/**
 * @author @muhammadtalib
 * created 10/01/2025
 */
public interface StorageTypeMasterService {


    StorageTypeMaster saveOrUpdateStorageType(StorageTypeMaster storageTypeMaster);

    StorageTypeMaster getStorageTypeById(Long id);

    List<StorageTypeMaster> getAllStorageType(Boolean isActive);

    GenericResponse deleteStorageTypeById(Long id);
}
