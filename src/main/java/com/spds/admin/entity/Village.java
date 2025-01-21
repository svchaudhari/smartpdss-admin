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
public class Village extends Auditable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7045202678147792996L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "village_seq_id")
	@SequenceGenerator(name = "village_seq_id", sequenceName = "village_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "village_town_ll", length = 150)
	private String villageTownLl;
	
	@Column(name = "village_town_en", length = 150)
	private String villageTownEn;
	
	@Column(name = "state_id", length = 150)
	private Long stateId;
	
	@Column(name = "district_id", length = 150)
	private Long districtId;
	
	@Column(name = "tehsil_id", length = 150)
	private Long tehsilId;
	
	@Column(name = "area_type", length = 150)
	private String areaType;
	
	@Column(name = "area_code", length = 150)
	private String areaCode;
	
	@Column(name = "panchayat_name_en", length = 150)
	private String panchayatNameEn;
	
	@Column(name = "panchayat_name_ll", length = 150)
	private String panchayatNameLl;
	
	@Column(name = "Senses", length = 150)
	private String senses;
	
	@Column(name = "document_upload_file", length = 150)
	private String documentUploadFile;
	
	@Column(name = "document_file_type", length = 150)
	private String documentFileType;
	
	@Column(name = "document_file_size", length = 150)
	private String documentFileSize;
	
	@Column(name = "document_file_name", length = 150)
	private String documentFileName;
	
	@Column(name = "document_file_extension", length = 150)
	private String documentFileExtension;
	
	@Column(name = "modified_by", length = 150)
	private String modifiedBy;
	
	@Column(name = "modified_date", length = 150)
	private String modifiedDate;
	
	@Column(name = "record_id", length = 150)
	private String recordId;
	
	@Column(name = "active", length = 150)
	private String active;
	
    @Column(name = "rgi_district", length = 150)
	private String rgiDistrict;
	
	@Column(name = "old_village_code", length = 150)
	private String oldVillageCode;
	
	@Column(name = "new_village_code", length = 150)
	private String newVillageCode;
	
	@Column(name = "lgd_village_code", length = 150)
	private String lgdVillageCode;
	
	@Column(name = "remark", length = 150)
	private String remark;
	
}
