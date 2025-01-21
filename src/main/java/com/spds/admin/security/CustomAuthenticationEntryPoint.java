package com.spds.admin.security;

import java.io.PrintWriter;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Component("customAuthenticationEntryPoint")
@ControllerAdvice
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException, java.io.IOException {
		// 401 Unauthorized
		log.info("Encountered AuthenticationException: {}", authException.getMessage());
		log.error("Encountered AuthenticationException", authException);
		writeErrorMsg(response, HttpServletResponse.SC_UNAUTHORIZED, authException);
	}

	@ExceptionHandler(value = { AccessDeniedException.class })
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, java.io.IOException {
		// 401 Unauthorized
		writeErrorMsg(response, HttpServletResponse.SC_FORBIDDEN, accessDeniedException);

	}

	private void writeErrorMsg(HttpServletResponse response, int statusCode, Exception e)
			throws IOException, java.io.IOException {
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
