package com.spds.admin.security;

import io.jsonwebtoken.impl.DefaultClaims;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
public class CustomDefaultClaims extends DefaultClaims{
	
	 public static final String USERID = "userId";
	 private Long userId;
	 
	 Long getUserId() {
		 return get(USERID, Long.class);
	 }
	 
	 
	

}
