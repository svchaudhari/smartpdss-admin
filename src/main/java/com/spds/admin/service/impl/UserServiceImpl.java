package com.spds.admin.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spds.admin.dto.LoginRequest;
import com.spds.admin.dto.PasswordChangeRequest;
import com.spds.admin.dto.RoleOffice;
import com.spds.admin.dto.UserPrincipal;
import com.spds.admin.entity.User;
import com.spds.admin.entity.UserAccessMapping;
import com.spds.admin.repository.UserAccessRepository;
import com.spds.admin.repository.UserRepository;
import com.spds.admin.service.UserService;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	private UserAccessRepository userAccessRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
			UserAccessRepository userAccessRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userAccessRepository = userAccessRepository;
	}

	@Override
	public User getUserDetails(Long userId) throws Exception {
		log.info("Get user details for: {}", userId);
		return userRepository.findById(userId).orElseThrow(() -> new Exception("user not found!"));
	}

	@Override
	public User createNewUser(User user) throws Exception {
		log.info("Create new user: {}", user);
		String encodePass = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePass);
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(Long.valueOf(username));
		return user.map(UserPrincipal::new)
				.orElseThrow(() -> new UsernameNotFoundException("UserName not found: " + username));
	}

	@Override
	public User validateUser(LoginRequest loginRequest) throws Exception {

		User user = userRepository.findByUserName(loginRequest.getUserName())
				.orElseThrow(() -> new Exception("The username you entered does not exist. Please check and try again.!!"));

		if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
			throw new Exception("The password you entered is incorrect. Please try again.!!");
		}

		return user;
	}

	@Override
	public List<RoleOffice> getAuthorities(Long userId) {
		return userAccessRepository.getUserPrivilagesByUserId(userId);
	}

	@Override
	public List<UserAccessMapping> assignRoleAndOffice(List<UserAccessMapping> userAccess) {
		return userAccessRepository.saveAll(userAccess);
	}

	@Override
	public String changePassword(PasswordChangeRequest passwordChangeRequest, Long userId) throws Exception {
		User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found!"));
		if (passwordEncoder.matches(passwordChangeRequest.getOldPassword(), user.getPassword())
				&& passwordChangeRequest.getNewPassword().equals(passwordChangeRequest.getReTypeNewPassword())) {
			user.setPassword(passwordEncoder.encode(passwordChangeRequest.getNewPassword()));
			userRepository.save(user);
		}

		return String.format("Password updated successfully for user:%s on %s ", user.getId(), Instant.now());
	}

}
