package com.spds.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spds.admin.entity.Tehsil;

@Repository
public interface TehsilRepository extends JpaRepository<Tehsil, Long> {
    
    // Custom query to find Tehsil by tehsilCode (assuming tehsilCode is unique)
    Optional<Tehsil> findById(Long id);

	List<Tehsil> findAllByIsActiveIsTrueAndIsDeletedIsFalse();
}
