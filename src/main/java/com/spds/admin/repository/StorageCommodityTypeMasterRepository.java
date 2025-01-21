package com.spds.admin.repository;

import com.spds.admin.entity.StorageCommodityTypeMaster;
import com.spds.admin.entity.StorageTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@Repository
public interface StorageCommodityTypeMasterRepository extends JpaRepository<StorageCommodityTypeMaster, Long> {

    Optional<StorageCommodityTypeMaster> findByIdAndIsDeletedFalseAndIsActiveTrue(Long id);

}