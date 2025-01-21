package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.Relationship;
import com.spds.admin.repository.RelationshipRepository;
import com.spds.admin.service.RelationshipService;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
@Service
public class RelationshipServiceImpl implements RelationshipService{

	@Autowired
	private RelationshipRepository relationshipRepository;
	
	@Override
	public Relationship createUpdate(Relationship relationship) {
		// TODO Auto-generated method stub
		Optional<Relationship> st=relationshipRepository.findById(relationship.getId());
		if(st.isPresent()) {
			relationship.setCreatedBy(st.get().getCreatedBy());
			relationship.setCreatedOn(st.get().getCreatedOn());
		}
		return relationshipRepository.save(relationship);
	}

	@Override
	public Relationship getRelationshipById(Long id) {
		// TODO Auto-generated method stub
		return relationshipRepository.findById(id).orElseThrow(()-> new RuntimeException("Relationship not found with ID: "+id));
	}

	@Override
	public List<Relationship> getAllRelationship(Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return relationshipRepository.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
		}else {
			return relationshipRepository.findAll();
			
		}
		
	}

	@Override
	public Relationship deleteRelationship(Long id) {
		// TODO Auto-generated method stub
		Relationship relationship=getRelationshipById(id);
		relationship.setActive(false);
		relationship.setDeleted(true);
		return relationshipRepository.save(relationship);
	}

	@Override
	public List<Relationship> getRelationshipByRsCode(String rsCode,Boolean isActive) {
		// TODO Auto-generated method stub
		if(isActive==true) {
			return relationshipRepository.findByRsCodeIsActiveIsTrueAndIsDeletedIsFalse(rsCode);
		}else {
			return relationshipRepository.findByRsCode(rsCode);
		}
		
	}

	

}
