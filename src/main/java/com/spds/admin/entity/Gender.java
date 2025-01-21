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
@Table(schema = "master",name = "gender")
public class Gender extends Auditable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7045202678147792996L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq_id")
	@SequenceGenerator(name = "gender_seq_id", sequenceName = "gender_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "gt_gender", length = 15)
	private String gtGender;
	
	@Column(name = "gt_genderll", length = 99)
	private String gtGenderLl;
	
	@Column(name = "SHORT_NAME", length = 1)
	private String shortName;
	
	@Column(name = "ration_fps_flag", length = 1)
	private String rationFpsFlag;
	
	
}
