package com.spds.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spds.admin.dto.LoginRequest;
import com.spds.admin.dto.RefreshTokenRequest;
import com.spds.admin.dto.TokenResponse;
import com.spds.admin.service.TokenService;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class TokenController {

	
	private TokenService tokenService;
	
	@Autowired
	TokenController(TokenService tokenService){
		this.tokenService=tokenService;
	}

	@PostMapping("/login")
	ResponseEntity<TokenResponse> generateToken(@RequestBody LoginRequest loginRequest) throws Exception {
		Authentication auth = tokenService.authenticate(loginRequest);
		String authToken = tokenService.generateToken(auth);
		String refreshToken = tokenService.generateRefreshToken(auth);
		TokenResponse token = new TokenResponse(authToken, refreshToken);
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

	@PostMapping("/refreshtoken")
	ResponseEntity<TokenResponse> generateRefreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest)
			throws Exception {
		Authentication auth = tokenService.getAuthentication(refreshTokenRequest.getRefreshToken());
		String authToken = tokenService.generateToken(auth);
		String refreshToken = tokenService.generateRefreshToken(auth);
		TokenResponse token = new TokenResponse(authToken, refreshToken);
		return new ResponseEntity<>(token, HttpStatus.OK);

	}

}
