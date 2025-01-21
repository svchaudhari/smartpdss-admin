package com.spds.admin.dto;

import java.io.Serializable;

import lombok.Data;

/**
 *@author abinjola
 *This class was creaded on 14-Dec-2024.
 * @param <T>
 */

@Data
public class GenericResponse<T> implements Serializable{
	private static final long serialVersionUID = -940047378330263973L;
	
	private boolean isError;
	
	private String errorMsg;
	
	private String successMsg;
	
	private T data;

	public GenericResponse(boolean isError, String errorMsg, String successMsg, T data) {
		super();
		this.isError = isError;
		this.errorMsg = errorMsg;
		this.successMsg = successMsg;
		this.data = data;
	}
		

}
