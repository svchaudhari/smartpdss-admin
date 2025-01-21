package com.spds.admin.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

/**
 * @author abinjola This class was creaded on 09-Dec-2024.
 */
@Data
public class UserPrivilages implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7099715396071765570L;

	private List<RoleOffice> userAccess;
	
	public UserPrivilages(List<RoleOffice> userAccess) {
		super();
		this.userAccess = userAccess;
	}

	@Override
	public String getAuthority() {
		if (this.userAccess != null && !this.userAccess.isEmpty()) {
			return String.join(",",
					userAccess.stream().map(ua -> String.valueOf(ua.getRole_id())).collect(Collectors.toList()));
		}
		return null;
	}


}
