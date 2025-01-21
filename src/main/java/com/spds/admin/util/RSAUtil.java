package com.spds.admin.util;

import java.util.Base64;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import com.spds.admin.constant.AppConst;

import lombok.extern.slf4j.Slf4j;

/**
 * @author abinjola This class was creaded on 17-Dec-2024.
 */
@Slf4j
public class RSAUtil {
	private static final String SECRECT_KEY = "SECRECT_KEY";

	public static void main(String[] args) {

		String input = "inputText";
		String output = encrypt(input);

		log.info("input={}, encryptedText={}, decryptText={}", input, output, decrypt(output));

	}

	/**
	 * <p>
	 * Method to encrypt plain text using secret key
	 * </p>
	 * 
	 * @param plainText
	 * @return
	 */
	public static String encrypt(String plainText) {
		return getEncryptor().encrypt(plainText);
	}

	/***
	 * <p>
	 * Method to decrypt encrypted text using secret key
	 * </p>
	 * 
	 * @param encrpytedText
	 * @return
	 */
	public static String decrypt(String encryptedText) {
		return getEncryptor().decrypt(encryptedText);
	}

	/***
	 * <p>
	 * Method to create Object of @PooledPBEStringEncryptor with custom
	 * configuration.
	 * </p>
	 * 
	 * @return
	 */
	private static StringEncryptor getEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(SECRECT_KEY);
		config.setAlgorithm(AppConst.ENCRYPTOR_ALGORITHM);
	    config.setKeyObtentionIterations(AppConst.ENCRYPTOR_ITERATIONS);
	    config.setPoolSize(AppConst.ENCRYPTOR_POOLSIZE);
	    config.setProviderName(AppConst.ENCRYPTOR_PROVIDER_NAME);
	    config.setSaltGeneratorClassName(AppConst.ENCRYPTOR_SALT_GENERATOR_CLASSNAME);
	    config.setStringOutputType(AppConst.ENCRYPTOR_OUTPUTTYPE);
		encryptor.setConfig(config);
		return encryptor;
	}

	/***
	 * <p>
	 * Method to decode base64 string using @Base64
	 * </p>
	 * 
	 * @param base64Str
	 * @return
	 */
	public static String decoderBase64(String base64Str) {
		return new String(Base64.getDecoder().decode(base64Str));
	}

}
