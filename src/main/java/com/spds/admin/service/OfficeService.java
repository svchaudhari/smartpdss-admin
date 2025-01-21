package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.Office;

/**
 *@author abinjola
 *This class was creaded on 14-Dec-2024.
 */
public interface OfficeService {
	
	public List<Office>getAllOffices(Boolean isActive);
	
	public Office createNewOffice(Office office);

}
