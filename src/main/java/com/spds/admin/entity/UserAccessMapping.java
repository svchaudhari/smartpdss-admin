package com.spds.admin.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author abinjola This class was creaded on 09-Dec-2024.
 */
@Data
@Entity
@Table(schema = "ua", name = "user_access_mapping")
public class UserAccessMapping extends Auditable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4209190098799310466L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_access_mapping_seq_id")
	@SequenceGenerator(name = "user_access_mapping_seq_id", sequenceName = "user_access_mapping_seq_id", schema = "ua", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "office_id")
	private Long officeId;

	@Column(name = "is_linked_officer")
	private boolean isLinkedOfficer;

	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

}
