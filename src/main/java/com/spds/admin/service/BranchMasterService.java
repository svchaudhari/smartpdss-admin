package com.spds.admin.service;

import com.spds.admin.entity.BankMaster;
import com.spds.admin.entity.BranchMaster;

import java.util.List;

public interface BranchMasterService {

    public BranchMaster createUpdate(BranchMaster branchMaster);
    public BranchMaster getById(Long id);
    public List<BranchMaster> getAll(Boolean isActive);
    public BranchMaster deleteById(Long id);
    public List<BranchMaster> getAllByBankId(Long bankId);
}
