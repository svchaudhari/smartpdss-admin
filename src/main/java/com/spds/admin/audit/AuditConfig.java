package com.spds.admin.audit;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
@Configuration
@EnableJpaAuditing
public class AuditConfig {

	public AuditorAware<Long> auditorAware() {
		return () -> Optional.of(Long.valueOf(1));
		
	}

}
