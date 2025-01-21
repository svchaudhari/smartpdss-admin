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
 *created 24 Dec 2024
 */

@Data
@Entity
@Table(schema="master",name="gas_company")
public class GasCompany extends Auditable implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4300001768129924089L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gascompany_seq_id")
	@SequenceGenerator(name = "gascompany_seq_id", sequenceName = "gascompany_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "name_en", length = 150)
	private String nameEn;
	
	@Column(name = "name_ll", length = 150)
	private String nameLl;
	
	@Column(name = "name_short", length = 15)
	private String nameShort;
	
	@Column(name = "remarks", length = 150)
	private String remarks;
}
