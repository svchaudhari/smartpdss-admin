package com.spds.admin.security;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.spds.admin.dto.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
@Component
public class JwtService {

	@Value("${jwt.secret}")
	private String jwtSecret;

	// Creates a signing key from the base64 encoded secret.
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	// Extracts the userName from the JWT token.
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	// Extracts the expiration date from the JWT token.
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	// Extracts a specific claim from the JWT token.

	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	// Extracts all claims from the JWT token.
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
	}

	// Checks if the JWT token is expired.
	public Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	// Validates the JWT token against the UserDetails.

	public Boolean validateToken(String token, UserPrincipal userDetails) {
		// Extract username from token and check if it matches UserDetails' username
		Claims claims=extractAllClaims(token);
		boolean refresh=(boolean) claims.get("refresh");
		final String userName = extractUserName(token);
		// Also check if the token is expired
		return (userName.equals(String.valueOf(userDetails.getUserId())) && !isTokenExpired(token) && !ObjectUtils.isEmpty(userDetails.getUserId()) && !refresh);
	}
}
