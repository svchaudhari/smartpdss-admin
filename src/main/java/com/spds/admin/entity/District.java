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
 * 
 *@author mohdksiddiqui
 *created 14 Dec 2024
 */

@Data
@Entity
@Table(schema = "master", name = "district")
public class District extends Auditable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4609970866031938399L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "district_seq_id")
	@SequenceGenerator(name = "district_seq_id", sequenceName = "district_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "dist_name_en", length = 150)
	private String distName;

	@Column(name = "dist_name_ll", length = 150)
	private String distNameLl;

	@Column(name = "dist_lgd_code", length = 3)
	private String distLgdCode;
	
	@Column(name = "state_id", length = 2)
	private Long stateId;

	@Column(name = "remarks", length = 100)
	private String remarks;

}
