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
 * @author abinjola This class was creaded on 09-Dec-2024.
 */

@Data
@Entity
@Table(schema = "ua", name = "office")
public class Office extends Auditable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8527435339705149745L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "office_seq_id")
	@SequenceGenerator(name = "office_seq_id", sequenceName = "office_seq_id", schema = "ua", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "office_name",length = 60)
	private String officeName;

	@Column(name = "office_abbr",length = 80)
	private String officeAbbr;

	@Column(name = "office_type_id")
	private Long officeTypeId;

	@Column(name = "parent_office_id")
	private Long parentOfficeId;

	@Column(name = "remarks",length = 100)
	private String remarks;

}
