package com.spds.admin.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spds.admin.constant.AppConst;
import com.spds.admin.util.RSAUtil;

/**
 * @author abinjola This class was creaded on 05-Dec-2024.
 */
@Configuration
public class AppConfig {
	
	@Value("${jasypt.encryptor.password}")
	String encryptorPassword;

	
	@Bean(name = "encryptorBean")
	public StringEncryptor stringEncryptor() {
	    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
	    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
	    config.setPassword(RSAUtil.decoderBase64(encryptorPassword));
	    config.setAlgorithm(AppConst.ENCRYPTOR_ALGORITHM);
	    config.setKeyObtentionIterations(AppConst.ENCRYPTOR_ITERATIONS);
	    config.setPoolSize(AppConst.ENCRYPTOR_POOLSIZE);
	    config.setProviderName(AppConst.ENCRYPTOR_PROVIDER_NAME);
	    config.setSaltGeneratorClassName(AppConst.ENCRYPTOR_SALT_GENERATOR_CLASSNAME);
	    config.setStringOutputType(AppConst.ENCRYPTOR_OUTPUTTYPE);
	    encryptor.setConfig(config);
	    return encryptor;
	}

}
