package com.spds.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spds.admin.entity.Role;
import com.spds.admin.repository.RoleRepository;
import com.spds.admin.service.RoleService;

/**
 * @author abinjola This class was creaded on 14-Dec-2024.
 */

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> getAllRoles(Boolean isActive) {
		return roleRepository.getAll(isActive);
	}

	@Override
	public Role createNewRole(Role role) {
		Optional<Role> st=roleRepository.findById(role.getId());
		if(st.isPresent()) {
			role.setCreatedBy(st.get().getCreatedBy());
			role.setCreatedOn(st.get().getCreatedOn());
		}
		return roleRepository.save(role);
	}

}
