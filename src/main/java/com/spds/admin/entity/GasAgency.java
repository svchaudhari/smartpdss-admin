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
@Table(schema="master",name="gas_agency")
public class GasAgency  extends Auditable implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -8743540635395139733L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gasagency_seq_id")
	@SequenceGenerator(name = "gasagency_seq_id", sequenceName = "gasagency_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "agency_name", length = 150)
	private String agencyName;
	
	@Column(name = "agency_owner_name", length = 150)
	private String agencyOwnerName;
	
	@Column(name = "agency_owner_name_ll", length = 150)
	private String agencyOwnerNameLl;
	
	@Column(name = "gas_company_id", length = 3)
	private String gasCompanyId;
	
	@Column(name = "address", length = 150)
	private String address;
	
	@Column(name = "contact_person", length = 55)
	private String contactPerson;
	
	@Column(name = "contact_number", length = 10)
	private String contactNumber;
	
	@Column(name = "district_id", length = 4)
	private String districtId;
}
