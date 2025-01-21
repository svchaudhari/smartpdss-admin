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
 *@author prakash
 *This class was creaded on 09-Dec-2024.
 */
@Data
@Entity
@Table(schema = "master",name = "village")
public class Relationship extends Auditable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7045202678147792996L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "village_seq_id")
	@SequenceGenerator(name = "disabilityMaster_seq_id", sequenceName = "disabilityMaster_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "rs_code", length = 150)
	private String rsCode;
	
	@Column(name = "gender_type_gt_type_id", length = 150)
	private int genderTypeGtTypeId;
	
	@Column(name = "rs_name_ll", length = 150)
	private String rsNameLl;
	
	@Column(name = "rs_name_en", length = 150)
	private String rsNameEn;
	
	@Column(name = "rs_active", length = 150)
	private int rsActive;
	
	
}
