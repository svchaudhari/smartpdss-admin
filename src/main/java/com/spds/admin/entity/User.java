package com.spds.admin.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
@Data
@Entity
@Table(schema = "ua", name = "user")
@NoArgsConstructor
public class User extends Auditable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -25365148147119768L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_id")
	@SequenceGenerator(name = "user_seq_id", sequenceName = "user_seq_id", schema = "ua", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_name",length = 60)
	private String userName;
	
	@Column(name = "email",length = 254)
	private String email;

	@Column(name = "password",length = 255)
	private String password;

	@Column(name = "mobile",length = 20)
	private String mobile;
	
	@Column(name = "remarks",length = 100)
	private String remarks;
	
	@Column(name = "full_name_en",length = 60)
	private String fullNameEn;
	
	@Column(name = "full_name_ll",length = 254)
	private String fullNamell;

	@Column(name = "dob",length = 255)
	private String dob;

	@Column(name = "gender",length = 100)
	private String gender;
	
	@Column(name = "mother_name_en",length = 255)
	private String motherNameEn;
	
	@Column(name = "mother_name_ll",length = 255)
	private String motherNameLl;
	
	@Column(name = "father_name_en",length = 20)
	private String fatherNameEn;
	
	@Column(name = "father_name_Ll",length = 20)
	private String fatherNameLl;

	@Column(name = "nationality",length = 20)
	private String nationality;

	@Column(name = "selected_role",length = 20)
	private String selectedRole;

	@Column(name = "selected_office",length = 20)
	private String selectedOffice;

	@Column(name = "user_invitation_id")
	private Long userInvitationId;
	
	public User(String userName) {
		super();
		this.userName = userName;
	}

	public User(Long id, String userName, String password, String mobile) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
	}
	 
		

}
