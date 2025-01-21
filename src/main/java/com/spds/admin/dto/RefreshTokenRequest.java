package com.spds.admin.dto;

import java.io.Serializable;

import lombok.Data;

/***
 * 
 * @author abinjola 
 * This class was creaded on 02-Dec-2024.
 */
@Data
public class RefreshTokenRequest implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -1044727339235239813L;

	private String refreshToken;

}
