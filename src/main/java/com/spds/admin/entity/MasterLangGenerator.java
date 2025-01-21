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

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 *@author mohdksiddiqui
 *created 20 Dec 2024
 */

@Data
@Entity
@Table(schema="master",name="master_lang_generator")
public class MasterLangGenerator extends Auditable implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -649962737975528485L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lang_gen_seq_id")
	@SequenceGenerator(name = "lang_gen_seq_id", sequenceName = "lang_gen_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "state_id", length = 2)
	private Long stateId;
	
	@Column(name = "ref_id", length = 5)
	private Long refId;
	
	@Column(name = "ref_type", length = 50)
	private String refType;
	
	@Column(name = "name_ll", length = 150)
	private String nameLL;
	
	@Column(name = "lang_type", length = 50)
	private String langType;
	
	@Column(name = "remarks", length = 100)
	private String remarks;

}
