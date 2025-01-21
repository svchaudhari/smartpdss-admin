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
@Table(schema = "master",name = "disability")
public class Disability extends Auditable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7045202678147792996L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disability_seq_id")
	@SequenceGenerator(name = "disabilityMaster_seq_id", sequenceName = "disabilityMaster_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "Codes", length = 4)
	private String disabilityCode;
	
	@Column(name = "DisabilityTypeEN", length = 200)
	private String disabilityTypeEN;
	
	@Column(name = "DisabilityTypeLL", length = 200)
	private String disabilityTypeLL;
	
	@Column(name = "ShortName", length = 50)
	private String shortName;
	
	
}