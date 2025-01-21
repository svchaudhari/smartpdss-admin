package com.spds.admin.service.impl;

import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.spds.admin.dto.LoginRequest;
import com.spds.admin.dto.RoleOffice;
import com.spds.admin.dto.UserPrivilages;
import com.spds.admin.entity.User;
import com.spds.admin.entity.UserInvitation;
import com.spds.admin.service.TokenService;
import com.spds.admin.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private Long jwtExpiration;

	@Value("${jwt.refresh-token.expiration}")
	private Long refreshTokenExpiration;

	private final KeyStore keyStore;

	private UserService userService;

	@Autowired
	public TokenServiceImpl(UserService userService)
			throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
		this.userService = userService;
		keyStore = KeyStore.getInstance("JKS");
		keyStore.load(null, null);
	}
	
	public String generateToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		List<RoleOffice> userAccess=userService.getAuthorities(user.getId());
		Claims claims = Jwts.claims().setSubject(String.valueOf(user.getId()));
		claims.put("userId", user.getId());
		claims.put("name", user.getUserName());
		claims.put("mobile", user.getMobile());
		claims.put("refresh", false);
		claims.put("roles", userAccess);
		Date now = new Date();
		Date expiration = new Date(now.getTime() + jwtExpiration);
		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(expiration)
				.signWith(getSignKey(), SignatureAlgorithm.HS512).compact();

	}

	public String generateInvitationToken(UserInvitation userInvitation) {
		//UserInvitation userInvitation = (UserInvitation) authentication.getPrincipal();
		//List<RoleOffice> userAccess = userService.getAuthorities(userInvitation.getId());
		Claims claims = Jwts.claims().setSubject(String.valueOf(userInvitation.getId()));
		claims.put("userId", userInvitation.getId());
		claims.put("email", userInvitation.getEmailId());
		claims.put("mobile", userInvitation.getMobileNumber());
		Date now = new Date();
		Date expiration = new Date(now.getTime() + Duration.ofDays(10).toMillis());
		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(expiration)
				.signWith(getSignKey(), SignatureAlgorithm.HS512).compact();

	}

	public String generateRefreshToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		Claims claims = Jwts.claims().setSubject(String.valueOf(user.getId()));
		claims.put("refresh", true);
		Date now = new Date();
		Date expiration = new Date(now.getTime() + refreshTokenExpiration);
		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(expiration)
				.signWith(getSignKey(), SignatureAlgorithm.HS512).compact();

	}

	public Authentication authenticate(LoginRequest loginRequest) throws Exception {

		User user = userService.validateUser(loginRequest);
		List<RoleOffice> userAccess = userService.getAuthorities(user.getId());
		UserPrivilages authorities = new UserPrivilages(userAccess);
		List<UserPrivilages> auth = new ArrayList<>();
		auth.add(authorities);
		return new UsernamePasswordAuthenticationToken(user, null, auth);
	}

	public Authentication getAuthentication(String token) throws Exception {
		validateToken(token);
		Claims claims = Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
		User user = userService.getUserDetails(Long.valueOf(claims.getSubject()));
		return new UsernamePasswordAuthenticationToken(user, null, null);

	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			return false;
		}
		return true;

	}

	private Key getSignKey() {
		// Decode the base64 encoded secret key and return a Key object
		byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
