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
@Table(schema="master",name="state_category")
public class StateCategory extends Auditable implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -6915689622952889123L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="state_category_seq_id")
	@SequenceGenerator(name="state_category_seq_id",sequenceName="state_category_seq_id",schema="master",allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="state_category_name", length=150)
	private String stateCategoryName;
	
	@Column(name="remarks", length=100)
	private String remarks;

}
