package com.spds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spds.admin.dto.GenericResponse;
import com.spds.admin.entity.Office;
import com.spds.admin.entity.Role;
import com.spds.admin.service.OfficeService;
import com.spds.admin.service.RoleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author abinjola This class was creaded on 14-Dec-2024.
 */

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class OfficeAndRoleController {

	private OfficeService officeService;

	private RoleService roleService;

	@Autowired
	public OfficeAndRoleController(OfficeService officeService, RoleService roleService) {
		this.officeService = officeService;
		this.roleService = roleService;
	}

	@GetMapping("/office/get-all")
	ResponseEntity<GenericResponse<List<Office>>> getAllOffices(@RequestParam("is_active") Boolean isActive)
			throws Exception {
		return new ResponseEntity<>(new GenericResponse<>(false, "",
				"Successfully fetched list of offices.", officeService.getAllOffices(isActive)), HttpStatus.OK);
	}

	@PostMapping("/office/create")
	ResponseEntity<GenericResponse<Office>> createNewOffice(@RequestBody Office office) throws Exception {

		return new ResponseEntity<>(new GenericResponse<>(false, "",
				"Created new office sucessfully.", officeService.createNewOffice(office)), HttpStatus.OK);
	}

	@GetMapping("/role/get-all")
	ResponseEntity<GenericResponse<List<Role>>> getAllRoles(@RequestParam("is_active") Boolean isActive)
			throws Exception {

		return new ResponseEntity<>(new GenericResponse<>(false, "",
				"Successfully fetched list of roles.", roleService.getAllRoles(isActive)), HttpStatus.OK);
	}

	@PostMapping("/role/create")
	ResponseEntity<GenericResponse<Role>> createNewRole(@RequestBody Role role) throws Exception {

		return new ResponseEntity<>(
				new GenericResponse<>(false, "", "Created new role sucessfully.", roleService.createNewRole(role)),
				HttpStatus.OK);
	}
}
