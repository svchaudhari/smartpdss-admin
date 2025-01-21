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
public class CasteCategory extends Auditable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7045202678147792996L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "village_seq_id")
	@SequenceGenerator(name = "casteCategoryMaster_seq_id", sequenceName = "casteCategoryMaster_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "CasteCategoryCode", length = 10)
	private int casteCategoryCode;
	
	@Column(name = "CasteCategoryNameEN", length = 50)
	private String casteCategoryNameEN;
	
	@Column(name = "CasteCategoryNameLL", length = 50)
	private String casteCategoryNameLL;
	
	@Column(name = "CasteCategoryShortName", length = 20)
	private String casteCategoryShortName;
	
	
}
