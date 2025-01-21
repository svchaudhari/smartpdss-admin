package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.CardScheme;
/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */
public interface CardSchemeService {

	CardScheme createUpdate(CardScheme cs);
	CardScheme getById(Long id);
	List<CardScheme> getAll(Boolean isActive);
	CardScheme delete(Long id);
}
