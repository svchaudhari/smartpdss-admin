package com.spds.admin.repository;

import com.spds.admin.entity.BankMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author @muhammadtalib
 * created 27 Dec 2024
 */

@Repository
public interface BankMasterRepository extends JpaRepository<BankMaster , Long> {

    List<BankMaster> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

}
