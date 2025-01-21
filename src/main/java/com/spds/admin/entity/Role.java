package com.spds.admin.entity;

import java.io.Serializable;

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
@Table(schema = "ua", name = "role")
public class Role extends Auditable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7257137511729182741L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq_id")
	@SequenceGenerator(name = "role_seq_id", sequenceName = "role_seq_id", schema = "ua", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "role_name",length = 60)
	private String roleName;

	@Column(name = "role_abbr",length = 80)
	private String roleAbbr;
	
	@Column(name = "parent_role_id")
	private Long parentRoleId;

	@Column(name = "remarks",length = 100)
	private String remarks;

}
