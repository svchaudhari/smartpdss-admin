package com.spds.admin.repository;

import com.spds.admin.entity.CommodityMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommodityMasterRepository extends JpaRepository<CommodityMaster, Long> {
    List<CommodityMaster> findAllByIsActiveIsTrueAndIsDeletedIsFalse();
}