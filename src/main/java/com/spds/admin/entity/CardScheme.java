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
@Table(schema="master",name="card_scheme_master")
public class CardScheme extends Auditable implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -7607675507550006506L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardscheme_seq_id")
	@SequenceGenerator(name = "cardscheme_seq_id", sequenceName = "cardscheme_seq_id", schema = "master", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "card_desc", length = 150)
	private String cardDesc;
	
	@Column(name = "card_desc_ll", length = 150)
	private String cardDescLl;
	
	@Column(name = "color_code", length = 50)
	private String colorCode;
	
	@Column(name = "uid_check", length = 1)
	private String uidCheck;
	
	@Column(name = "dbt_check", length = 1)
	private String dbtCheck;
	
	@Column(name = "scheme_detail", length = 200)
	private String schemeDetail;

}
