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
@Table(schema="master",name="procurement_type")
public class ProcurementType extends Auditable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -838290135014787537L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="procurement_seq_id")
	@SequenceGenerator(name="procurement_seq_id",sequenceName="procurement_seq_id",schema="master",allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="procurement_name", length=150)
	private String procurementName;
	
	@Column(name="remarks", length=100)
	private String remarks;

}
