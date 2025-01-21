package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.Relationship;
/**
 * 
 *@author prakash
 *created 14 Dec 2024
 */
public interface RelationshipService {

	Relationship createUpdate(Relationship relationship);
	Relationship getRelationshipById(Long id);
	List<Relationship> getAllRelationship(Boolean isActive);
	Relationship deleteRelationship(Long id);
	List<Relationship> getRelationshipByRsCode(String rsCode, Boolean isActive);
}
