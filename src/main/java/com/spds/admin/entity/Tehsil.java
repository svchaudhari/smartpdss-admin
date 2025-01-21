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
@Table(schema = "master",name = "tehsil")
public class Tehsil extends Auditable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4445644907692215300L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tehsil_seq_id")
	@SequenceGenerator(name = "tehsil_seq_id", sequenceName = "tehsil_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tehsil_name_ll", length = 150)
	private String tehsilNameLl;
	
	@Column(name = "tehsil_name_en", length = 150)
	private String tehsilNameEn;
	
	@Column(name = "tehsil_shortname", length = 150)
	private String tehsilShortname;
	
	@Column(name = "tehsil_active", length = 150)
	private String tehsilActive;
	
	@Column(name = "state_id", length = 150)
	private String stateId;
	
	@Column(name = "district_id", length = 150)
	private String districtId;
	
	@Column(name = "tehsil_remark", length = 150)
	private String tehsilRemark;
	
	@Column(name = "rgi_district", length = 150)
	private String rgiDistrict;
	
	@Column(name = "old_tehsil_code", length = 150)
	private String oldTehsilCode;

	@Column(name = "lgd_tehsil_code", length = 150)
	private String lgdTehsilCode;
	
	
}
