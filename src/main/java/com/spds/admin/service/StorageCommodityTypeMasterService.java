package com.spds.admin.service;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.StorageCommodityTypeMaster;

import java.util.List;

/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

public interface StorageCommodityTypeMasterService {

    StorageCommodityTypeMaster saveOrUpdateStorageCommodityType(StorageCommodityTypeMaster storageCommodityTypeMaster);

    StorageCommodityTypeMaster getStorageCommodityTypeById(Long id);

    List<StorageCommodityTypeMaster> getAllStorageCommodityType();

    GenericResponse deleteStorageCommodityTypeById(Long id);
}
