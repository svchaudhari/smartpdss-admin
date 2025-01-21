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

@Data
@Entity
@Table(schema="master",name="pds_ownership_type")
public class PdsOwnershipType extends Auditable implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -1351558643514564279L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pds_ownsershiptype_seq_id")
	@SequenceGenerator(name="pds_ownsershiptype_seq_id",sequenceName="pds_ownsershiptype_seq_id",schema="master",allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="pds_ownership_type_name", length=150)
	private String pdsOwnsershipTypeName;
	
	@Column(name="remarks", length=100)
	private String remarks;
}
