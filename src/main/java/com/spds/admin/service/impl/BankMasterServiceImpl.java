package com.spds.admin.service.impl;

import com.spds.admin.entity.BankMaster;
import com.spds.admin.entity.State;
import com.spds.admin.repository.BankMasterRepository;
import com.spds.admin.service.BankMasterService;
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
public class BankMasterServiceImpl implements BankMasterService {

    @Autowired
    private BankMasterRepository bankMasterRepository;

    @Override
    public BankMaster createUpdate(BankMaster bankMaster) {
        // TODO Auto-generated method stub
    	Optional<BankMaster> st=bankMasterRepository.findById(bankMaster.getId());
		if(st.isPresent()) {
			bankMaster.setCreatedBy(st.get().getCreatedBy());
			bankMaster.setCreatedOn(st.get().getCreatedOn());
		}
    	
        return bankMasterRepository.save(bankMaster);
    }

    @Override
    public BankMaster getById(Long id) {
        // TODO Auto-generated method stub
        return bankMasterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bank Master not found with ID: " + id));
    }

    @Override
    public List<BankMaster> getAll(Boolean isActive) {
        // TODO Auto-generated method stub
        if (isActive == true)
            return bankMasterRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
        else
            return bankMasterRepository.findAll();
    }

    @Override
    public BankMaster deleteById(Long id) {
        BankMaster bankMaster = getById(id);
        bankMaster.setActive(false);
        bankMaster.setDeleted(true);
        return bankMasterRepository.save(bankMaster);
    }
}
