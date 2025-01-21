package com.spds.admin.service.impl;

import com.spds.admin.constant.AppConst;
import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.DepotMaster;
import com.spds.admin.repository.DepotMasterRepository;
import com.spds.admin.service.DepotMasterService;
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
public class DepotMasterServiceImpl implements DepotMasterService {

    public static final String DELETE_DEPOT_DETAILS = "Depot details delete successfully.";

    @Autowired
    private DepotMasterRepository depotMasterRepository;

    @Override
    public DepotMaster saveOrUpdateDepotDetails(DepotMaster depotMaster) {
    	Optional<DepotMaster> st=depotMasterRepository.findById(depotMaster.getId());
		if(st.isPresent()) {
			depotMaster.setCreatedBy(st.get().getCreatedBy());
			depotMaster.setCreatedOn(st.get().getCreatedOn());
		}
        return this.depotMasterRepository.save(depotMaster);
    }

    @Override
    public DepotMaster getDepotDetailsById(Long id) {
        return this.depotMasterRepository.findByIdAndIsDeletedFalseAndIsActiveTrue(id).orElseThrow(() -> new NoSuchElementException(AppConst.Message.Error.DEPOT_DETAILS_NOT_FOUND));
    }

    @Override
    public List<DepotMaster> getAllDepot() {
        List<DepotMaster> listOfDepot = this.depotMasterRepository.findAll();
        if(listOfDepot.isEmpty()){
            throw new NullPointerException(AppConst.Message.Error.DEPOT_DETAILS_NOT_FOUND);
        }
        return listOfDepot;
    }

    @Override
    public GenericResponse deleteDepotById(Long id) {
        Optional<DepotMaster> depotDetails = this.depotMasterRepository.findByIdAndIsDeletedFalseAndIsActiveTrue(id);
        if(depotDetails.isEmpty()){
            return new GenericResponse(true,AppConst.Message.Error.DEPOT_DETAILS_NOT_FOUND,null , depotDetails);
        }
        depotDetails.get().setActive(false);
        depotDetails.get().setDeleted(true);
        DepotMaster deletedDepotDetails = this.depotMasterRepository.save(depotDetails.get());
        return new GenericResponse(false,null, DELETE_DEPOT_DETAILS, deletedDepotDetails);
    }
}
