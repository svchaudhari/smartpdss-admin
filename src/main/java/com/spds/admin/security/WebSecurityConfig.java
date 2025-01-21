package com.spds.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.spds.admin.repository.UserAccessRepository;
import com.spds.admin.repository.UserRepository;
import com.spds.admin.service.impl.UserServiceImpl;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Configuration
@EnableWebSecurity
@CrossOrigin
public class WebSecurityConfig {

	private JwtFilter jwtFilter;

	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	private UserAccessRepository userAccessRepository;

	@Autowired
	public WebSecurityConfig(JwtFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}

	// Defines a UserDetailsService bean for user authentication
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl(userRepository, passwordEncoder, userAccessRepository);
	}

	// Configures the security filter chain
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
			@Qualifier("customAuthenticationEntryPoint") AuthenticationEntryPoint authEntryPoint) throws Exception {
		String[] paths = { "/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs", "/swagger-ui.html", "/api/v1/auth/**",
				"/actuator/health", "/actuator/prometheus", "/actuator/prometheus/**","/metrics"};
		return httpSecurity.cors(Customizer.withDefaults()) // Apply CORS
				.csrf(csrf -> csrf.disable()).httpBasic(basic -> basic.authenticationEntryPoint(authEntryPoint)) // Disable
																													// CSRF
																													// protection
				.authorizeHttpRequests(auth -> auth.requestMatchers("/**")

						.permitAll()// Permit
						// all
						// requests
						// to
						// certain
						// URLs
						.anyRequest().authenticated())
				.exceptionHandling(Customizer.withDefaults()) // Require authentication for all other requests
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Set
																												// session
																												// management
																												// to //
																												// stateless
				.authenticationProvider(authenticationProvider()) // Register the authentication provider
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Add the JWT filter before
																						// processing the request
				.build();
	}

	// Creates a DaoAuthenticationProvider to handle user authentication
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	// Defines a PasswordEncoder bean that uses bcrypt hashing by default for
	// password encoding
	@Bean
	PasswordEncoder passwordEncoder() {
		return new Argon2PasswordEncoder(16, 32, 2, 65536, 3);
	}

	// Defines an AuthenticationManager bean to manage authentication processes
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	

}
