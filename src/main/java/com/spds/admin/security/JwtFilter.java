package com.spds.admin.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spds.admin.dto.UserPrincipal;
import com.spds.admin.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

	
	private JwtService jwtService;
	private ApplicationContext applicationContext;
	
	
	@Autowired
	public JwtFilter(JwtService jwtService, ApplicationContext applicationContext) {
		this.jwtService = jwtService;
		this.applicationContext = applicationContext;
	}

	// Method to lazily fetch the UserService bean from the ApplicationContext
	// This is done to avoid Circular Dependency issues
	private UserService getUserService() {
		return applicationContext.getBean(UserService.class);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Extracting token from the request header
		try {
			String authHeader = request.getHeader("Authorization");
			String token = null;
			String userName = null;

			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				// Extracting the token from the Authorization header
				token = authHeader.substring(7);
				// Extracting username from the token
				userName = jwtService.extractUserName(token);
			}
			log.info("info-Client remote address: {}, user: {}", request.getRemoteAddr(), userName);
			log.debug("debug-Client remote address: {}, user: {},requested uri: {}", request.getRemoteAddr(), userName,
					request.getRequestURI());
			log.error("error-Client remote address: {}, user: {},requested uri: {}", request.getRemoteAddr(), userName,
					request.getRequestURI());
			// If username is extracted and there is no authentication in the current
			// SecurityContext
			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				// Loading UserDetails by username extracted from the token
				UserDetails userDetails = getUserService().loadUserByUsername(userName);

				// Validating the token with loaded UserDetails
				if (Boolean.TRUE.equals(jwtService.validateToken(token, (UserPrincipal) userDetails))) {
					// Creating an authentication token using UserDetails
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());
					// Setting authentication details
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					// Setting the authentication token in the SecurityContext
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		} catch (JwtException e) {
			writeErrorMsg(response, HttpServletResponse.SC_UNAUTHORIZED, e);
			return;
		} 

		// Proceeding with the filter chain

		filterChain.doFilter(request, response);

	}

	private void writeErrorMsg(HttpServletResponse response, int statusCode, Exception e) throws IOException {
		String errorMsg = """
				{
				"error":"#msg#"
				}
				""";
		response.setStatus(statusCode);
		response.setContentType("application/json");

		PrintWriter writer = response.getWriter();
		writer.write(errorMsg.replace("#msg#", e.getMessage()));
		writer.flush();
	}
}