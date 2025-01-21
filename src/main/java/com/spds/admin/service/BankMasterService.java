package com.spds.admin.service;

import com.spds.admin.entity.BankMaster;

import java.util.List;

public interface BankMasterService {

    public BankMaster createUpdate(BankMaster bankMaster);

    public BankMaster getById(Long id);

    public List<BankMaster> getAll(Boolean isActive);

    public BankMaster deleteById(Long id);
}
