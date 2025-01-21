package com.spds.admin.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spds.admin.entity.User;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
public class UserPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Long userId = null;
	private String userName = null;
	private String password = null;
	private String mobile = null;
	private Set<SimpleGrantedAuthority> authorities;

	public UserPrincipal(User user) {
		userId = user.getId();
		userName = user.getUserName();
		password = user.getPassword();
		mobile = user.getMobile();
		authorities = Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	public Long getUserId() {
		return userId;
	}

	public String getMobile() {
		return mobile;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
