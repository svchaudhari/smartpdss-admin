package com.spds.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "SPDS Admin", description = "All API definitions for SPDS Admin", version = "1.0.0"))
@EnableFeignClients
public class SpdsAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpdsAdminApplication.class, args);
	}

}
