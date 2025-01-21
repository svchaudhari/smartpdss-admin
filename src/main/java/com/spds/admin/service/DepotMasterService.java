package com.spds.admin.service;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.DepotMaster;

import java.util.List;

/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

public interface DepotMasterService {

    DepotMaster saveOrUpdateDepotDetails(DepotMaster depotMaster);

    DepotMaster getDepotDetailsById(Long id);

    List<DepotMaster> getAllDepot();

    GenericResponse deleteDepotById(Long id);

}
