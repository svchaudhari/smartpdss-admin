package com.spds.admin.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -219399087553073685L;

	private String token;
	private String refreshToken;

}
