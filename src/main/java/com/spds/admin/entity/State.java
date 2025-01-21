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
@Table(schema = "master", name = "state")
public class State extends Auditable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8343557481558438946L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq_id")
	@SequenceGenerator(name = "state_seq_id", sequenceName = "state_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "state_name_en", length = 150)
	private String stateName;

	@Column(name = "state_name_ll", length = 150)
	private String stateNameLl;

	@Column(name = "state_lgd_code", length = 3)
	private String stateLgdCode;
	
	@Column(name="state_short_name", length=100)
	private String stateShortName;
	
	@Column(name="is_ut", length=1)
	private boolean isUT;
	
	@Column(name="is_dbt", length=1)
	private boolean isDBT;
	
	@Column(name="is_central_pgrms_state", length=1)
	private boolean isCentralPGRMSState;
	
	@Column(name="is_mobile_app_available", length=1)
	private boolean isMobileApp;
	
	@Column(name="is_rcms_hosted_nfsa", length=1)
	private boolean isRCMSHostedNFSA;
	
	@Column(name="is_common_rc_facility", length=1)
	private boolean isCommonRCFacility;
	
	@Column(name="is_fps_available_on_mobile", length=1)
	private boolean isAvailableFPSMobile;
	
	@Column(name="procurement_id", length=3)
	private Long procurementId;
	
	@Column(name="state_category_id", length=3)
	private Long stateCategoryId;
	
	@Column(name="pds_ownership_type_id", length=3)
	private Long pdsOwnsershipTypeId;
	
	@Column(name = "remarks", length = 100)
	private String remarks;

}
