package com.spds.admin.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spds.admin.dto.LoginRequest;
import com.spds.admin.dto.PasswordChangeRequest;
import com.spds.admin.dto.RoleOffice;
import com.spds.admin.entity.User;
import com.spds.admin.entity.UserAccessMapping;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
public interface UserService {
	
	public User getUserDetails(Long userId) throws Exception;
	
	public User createNewUser(User user) throws Exception;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public User validateUser(LoginRequest loginRequest) throws Exception;
	
	public List<RoleOffice> getAuthorities(Long userId);
	
	public List<UserAccessMapping> assignRoleAndOffice(List<UserAccessMapping> userAccess);
	
	public String changePassword(PasswordChangeRequest passwordChangeRequest,Long userId) throws Exception;

}
