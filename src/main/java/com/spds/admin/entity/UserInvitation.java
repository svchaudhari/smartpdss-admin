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
@Table(schema="ua",name="user_invitation")
public class UserInvitation extends Auditable implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 4137434546511472910L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userinvite_seq_id")
	@SequenceGenerator(name = "userinvite_seq_id", sequenceName = "userinvite_seq_id", schema = "ua", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "application_id",length=15)
	private Long applicationId;
	
	@Column(name = "full_name",length = 60)
	private String fullName;
	
	@Column(name = "email_id",length = 60)
	private String emailId;
	
	@Column(name = "mobile_number",length = 10)
	private String mobileNumber;
	
	@Column(name = "status",length = 20)
	private String status = "PENDING";
	
	@Column(name = "state_id",length = 2)
	private Long stateId;
	
	@Column(name = "office_id",length = 5)
	private Long officeId;
	
	@Column(name = "role_id",length = 5)
	private Long roleId;
	
	@Column(name = "remarks",length = 255)
	private String remarks;
	
	@Column(name = "invitation_token",length = 1000)
	private String invitationToken;

}
