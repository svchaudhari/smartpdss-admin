package com.spds.admin.service;

import com.spds.admin.entity.MasterLangGenerator;

/**
 * 
 *@author mohdksiddiqui
 *created 20 Dec 2024
 */
public interface MasterLangGeneratorService {

	MasterLangGenerator createMasterLangGen(MasterLangGenerator mlg);

	MasterLangGenerator getMasterLangGen(String refType, String langType, Long stateId);

	
	
}
