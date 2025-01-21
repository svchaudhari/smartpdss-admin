package com.spds.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spds.admin.entity.CardScheme;
/**
 * 
 *@author mohdksiddiqui
 *created 26 Dec 2024
 */
public interface CardSchemeRepository extends JpaRepository<CardScheme, Long>{

	List<CardScheme> findAllByIsActiveIsTrueAndIsDeletedIsFalse();

}
