package com.spds.admin.constant;

/**
 * @author abinjola This class was creaded on 14-Dec-2024.
 */
public class AppConst {
	
	public static final String ENCRYPTOR_ALGORITHM="PBEWithMD5AndDES";
	public static final String ENCRYPTOR_ITERATIONS="1000";
	public static final String ENCRYPTOR_POOLSIZE="1";

	public static final String ENCRYPTOR_PROVIDER_NAME="SunJCE";
	public static final String ENCRYPTOR_SALT_GENERATOR_CLASSNAME="org.jasypt.salt.RandomSaltGenerator";
	public static final String ENCRYPTOR_OUTPUTTYPE="base64";

	private AppConst() {
		throw new IllegalStateException("AppConst class");
	}

	public class Message {
		private Message() {
			throw new IllegalStateException("MESSAGE class");
		}

		public class Success {
			private Success() {
				throw new IllegalStateException("Success class");
			}

			public static final String GET_ALL_OFFICES = "Office details fetched successfully";
			public static final String CREATE_NEW_OFFICE = "Office created successfully";
			public static final String GET_ALL_ROLES = "Roles details fetched successfully";
			public static final String CREATE_NEW_ROLE = "Role created successfully";
			public static final String GET_DEPOT_DETAILS = "Depot details retrieved successfully.";

		}

		public class Error {
			private Error() {
				throw new IllegalStateException("Error class");
			}

			public static final String OFFICE_ERROR = "Office details fetched successfully";
			public static final String DEPOT_DETAILS_NOT_FOUND = "Depot details unavailable. Please verify and try again.";
			public static final String STORAGE_DETAILS_NOT_FOUND= "Storage details unavailable. Please verify and try again.";
			public static final String STORAGE_COMMODITY_DETAILS_NOT_FOUND= "Storage commodity details unavailable. Please verify and try again.";

		}
	}

}
