package com.spds.admin.audit;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.spds.admin.entity.Auditable;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Component
public class AuditingEntityListener {

	private AuditorAware<Long> auditorAware;

	@Autowired
	AuditingEntityListener(AuditorAware<Long> auditorAware) {
		this.auditorAware = auditorAware;
	}

	@PrePersist
	public void onPrePersist(Auditable entity) {
		auditorAware.getCurrentAuditor().ifPresent(auditor -> {
			entity.setCreatedBy(auditor);
			entity.setUpdatedBy(auditor);
		});
		entity.setCreatedOn(LocalDateTime.now());
		entity.setUpdatedOn(LocalDateTime.now());

	}

	@PreUpdate
	public void onPreUpdate(Auditable entity) {
		auditorAware.getCurrentAuditor().ifPresent(entity::setUpdatedBy);
		entity.setUpdatedOn(LocalDateTime.now());
	}

}
