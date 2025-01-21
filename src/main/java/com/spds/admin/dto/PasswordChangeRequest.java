package com.spds.admin.dto;

import lombok.Data;

/**
 *@author abinjola
 *This class was creaded on 11-Dec-2024.
 */
@Data
public class PasswordChangeRequest {
	
	private String oldPassword;
	
	private String newPassword;
	
	private String reTypeNewPassword;

}
