package com.spds.admin.repository;

import com.spds.admin.entity.FPSDepotMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FPSDepotMappingRepository extends JpaRepository<FPSDepotMapping, Long> {
    List<FPSDepotMapping> findAllByIsActiveIsTrueAndIsDeletedIsFalse();
}