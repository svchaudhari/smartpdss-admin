package com.spds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spds.admin.dto.PasswordChangeRequest;
import com.spds.admin.entity.User;
import com.spds.admin.entity.UserAccessMapping;
import com.spds.admin.service.UserService;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/get")
	ResponseEntity<User> getUserDetails(@RequestParam("user_id") Long userId) throws Exception {
		return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
	}

	@PostMapping("/create")
	ResponseEntity<User> createNewUser(@RequestBody User user) throws Exception {
		return new ResponseEntity<>(userService.createNewUser(user), HttpStatus.OK);
	}

	@PostMapping("/assign/role-office")
	ResponseEntity<List<UserAccessMapping>> assignRole(@RequestBody List<UserAccessMapping> userAccess)
			throws Exception {
		return new ResponseEntity<>(userService.assignRoleAndOffice(userAccess), HttpStatus.OK);
	}

	@PostMapping("/change-password")
	ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest,
			@AuthenticationPrincipal User user) throws Exception {
		return new ResponseEntity<>(userService.changePassword(passwordChangeRequest, user.getId()),
				HttpStatus.OK);
	}

}
