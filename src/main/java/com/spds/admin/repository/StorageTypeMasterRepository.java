package com.spds.admin.repository;

import com.spds.admin.entity.StorageTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@Repository
public interface StorageTypeMasterRepository extends JpaRepository<StorageTypeMaster, Long> {

    Optional<StorageTypeMaster> findByIdAndIsDeletedFalseAndIsActiveTrue(Long id);
    List<StorageTypeMaster> findAllByIsDeletedFalseAndIsActiveTrue();
    List<StorageTypeMaster> findAllByIsDeletedFalse();
}