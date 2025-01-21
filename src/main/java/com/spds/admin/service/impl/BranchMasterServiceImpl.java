package com.spds.admin.service.impl;

import com.spds.admin.entity.BranchMaster;
import com.spds.admin.repository.BranchMasterRepository;
import com.spds.admin.service.BranchMasterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author @muhammadtalib
 * created 27 Dec 2024
 */


@Service
public class BranchMasterServiceImpl implements BranchMasterService {

    @Autowired
    private BranchMasterRepository branchMasterRepository;

    @Override
    public BranchMaster createUpdate(BranchMaster branchMaster) {
    	
    	Optional<BranchMaster> st=branchMasterRepository.findById(branchMaster.getId());
		if(st.isPresent()) {
			branchMaster.setCreatedBy(st.get().getCreatedBy());
			branchMaster.setCreatedOn(st.get().getCreatedOn());
		}
    	
        return branchMasterRepository.save(branchMaster);
    }

    @Override
    public BranchMaster getById(Long id) {
        return branchMasterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bank Master not found with ID: " + id));
    }

    @Override
    public List<BranchMaster> getAll(Boolean isActive) {
        if (isActive == true)
            return branchMasterRepository.findAllByIsActiveTrueAndIsDeletedFalse();
        else
            return branchMasterRepository.findAll();

    }

    @Override
    public BranchMaster deleteById(Long id) {
        BranchMaster branchMaster = getById(id);
        branchMaster.setDeleted(true);
        branchMaster.setActive(false);
        return branchMasterRepository.save(branchMaster);
    }

    @Override
    public List<BranchMaster> getAllByBankId(Long bankId) {
        return branchMasterRepository.findAllByBankIdAndIsActiveTrueAndIsDeletedFalse(bankId);
    }
}
