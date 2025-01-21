package com.spds.admin.service;

import org.springframework.security.core.Authentication;

import com.spds.admin.dto.LoginRequest;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
public interface TokenService {

	public String generateToken(Authentication authentication);

	public String generateRefreshToken(Authentication authentication);

	public Authentication authenticate(LoginRequest loginRequest) throws Exception;

	public Authentication getAuthentication(String token) throws Exception;

}
