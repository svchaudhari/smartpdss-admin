package com.spds.admin.repository;

import com.spds.admin.entity.DepotMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@Repository
public interface DepotMasterRepository extends JpaRepository<DepotMaster, Long> {

    Optional<DepotMaster> findByIdAndIsDeletedFalseAndIsActiveTrue(Long id);
}