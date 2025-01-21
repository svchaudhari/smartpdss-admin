package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.CardScheme;
import com.spds.admin.repository.CardSchemeRepository;
import com.spds.admin.service.CardSchemeService;

import jakarta.persistence.EntityNotFoundException;

/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */

@Service
public class CardSchemeServiceImpl implements CardSchemeService{

	@Autowired
	private CardSchemeRepository cardSchemeRepo;
	
	
	@Override
	public CardScheme createUpdate(CardScheme cs) {
		// TODO Auto-generated method stub
		Optional<CardScheme> st=cardSchemeRepo.findById(cs.getId());
		if(st.isPresent()) {
			cs.setCreatedBy(st.get().getCreatedBy());
			cs.setCreatedOn(st.get().getCreatedOn());
		}
		
		return cardSchemeRepo.save(cs);
	}

	@Override
	public CardScheme getById(Long id) {
		// TODO Auto-generated method stub
		return cardSchemeRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Card Scheme not found with ID: " + id));
	}

	@Override
	public List<CardScheme> getAll(Boolean isActive) {
		// TODO Auto-generated method stub
				if(isActive==true) {
				return cardSchemeRepo.findAllByIsActiveIsTrueAndIsDeletedIsFalse();
				}
				else {
					return cardSchemeRepo.findAll();
				}
	}

	@Override
	public CardScheme delete(Long id) {
		CardScheme cs=getById(id);
		cs.setActive(false);
		cs.setDeleted(true);
		return cardSchemeRepo.save(cs);
	}

}
