package com.spds.admin.service;

import java.util.List;

import com.spds.admin.entity.Role;

/**
 *@author abinjola
 *This class was creaded on 14-Dec-2024.
 */
public interface RoleService {
	
	public List<Role>getAllRoles(Boolean isActive);
	
	public Role createNewRole(Role role);
}
