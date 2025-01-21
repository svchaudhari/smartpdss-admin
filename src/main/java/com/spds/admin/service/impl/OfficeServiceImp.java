package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.Office;
import com.spds.admin.repository.OfficeRepository;
import com.spds.admin.service.OfficeService;

/**
 * @author abinjola This class was creaded on 14-Dec-2024.
 */

@Service
public class OfficeServiceImp implements OfficeService {

	private OfficeRepository officeRepository;

	@Autowired
	public OfficeServiceImp(OfficeRepository officeRepository) {
		this.officeRepository = officeRepository;
	}

	@Override
	public List<Office> getAllOffices(Boolean isActive) {
		return officeRepository.getAll(isActive);
	}

	@Override
	public Office createNewOffice(Office office) {
		Optional<Office> st=officeRepository.findById(office.getId());
		if(st.isPresent()) {
			office.setCreatedBy(st.get().getCreatedBy());
			office.setCreatedOn(st.get().getCreatedOn());
		}
		return officeRepository.save(office);
	}

}
