package com.spds.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spds.admin.entity.MasterLangGenerator;

public interface MasterLangGeneratorRepository extends JpaRepository<MasterLangGenerator, Long> {
	
	@Query(value="select * from master.get_state_master_lang(?1,?2,?3)",nativeQuery=true)
	MasterLangGenerator findByStateId(Long stateId,String refType,String langType);

}
