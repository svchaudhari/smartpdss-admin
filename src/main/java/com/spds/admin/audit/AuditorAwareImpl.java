package com.spds.admin.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.spds.admin.dto.UserPrincipal;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Slf4j
@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

	@Override
	public Optional<Long> getCurrentAuditor() {
		try {
			UserPrincipal userName = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			log.info("Current auditor:{}", userName);
			return Optional.of(userName.getUserId());
		} catch (Exception e) {
			log.info("Current auditor: not found!");
		}
		return Optional.of(Long.valueOf(1));
	}

}