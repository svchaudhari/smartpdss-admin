package com.spds.admin.dto;

import java.io.Serializable;

import lombok.Data;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
@Data
public class LoginRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 714091053552960765L;
	
	private String userName;
	private String password;

}
