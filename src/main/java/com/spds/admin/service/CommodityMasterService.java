package com.spds.admin.service;

import com.spds.admin.entity.CommodityMaster;

import java.util.List;

public interface CommodityMasterService {

    CommodityMaster createCommodityMaster(CommodityMaster commodityMaster);

    CommodityMaster getCommodityMasterById(Long id);

    CommodityMaster updateCommodityMaster(Long id, CommodityMaster commodityMaster);

    void deleteCommodityMaster(Long id);

    List<CommodityMaster> getAllCommodityMasters();
}
