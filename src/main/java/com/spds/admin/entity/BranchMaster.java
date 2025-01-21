package com.spds.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author @muhammadtalib
 * created 27 Dec 2024
 */


@Data
@Entity
@Table(schema = "master", name = "branch_master")
public class BranchMaster extends Auditable implements Serializable {

    private static final long serialVersionUID = 2169752432105870526L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_master_seq_id")
    @SequenceGenerator(name = "branch_master_seq_id", sequenceName = "branch_master_seq_id", schema = "master", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "bank_id", length = 3)
    private Long bankId;

    @Column(name = "ifsc_code", length = 11)
    private String ifscCode;

    @Column(name = "micr_code", length = 20)
    private String micrCode;

    @Column(name = "branch_name_en", length = 500)
    private String branchNameEn;

    @Column(name = "branch_landmark_en", length = 500)
    private String branchLandmarkEn;

    @Column(name = "branch_village_town_name_en", length = 50)
    private String branchVillageTownNameEn;

    @Column(name = "branch_tehsil_tahluk_subdistrict_name_en", length = 50)
    private String branchTehsilTahlukSubdistrictNameEn;

    @Column(name = "branch_district_name_en", length = 50)
    private String branchDistrictNameEn;

    @Column(name = "branch_state_name_en", length = 50)
    private String branchStateNameEn;

    @Column(name = "branch_postal_pin", length = 6)
    private String branchPostalPin;

    @Column(name = "state_id", length = 2)
    private String stateId;

    @Column(name = "district_id", length = 3)
    private String districtId;

    @Column(name = "tehsil_tahuk_block_id", length = 5)
    private String tehsilTahukBlockId;

    @Column(name = "village_id", length = 16)
    private String villageId;

    @Column(name = "plc_code", length = 16)
    private String plcCode;

    @Column(name = "branch_name_ll", length = 500)
    private String branchNameLl;

    @Column(name = "contact", length = 11)
    private String contact;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "pin_code", length = 6)
    private String pinCode;

    @Column(name = "status", length = 1)
    private char status;

    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "old_bank_branch_code", length = 12)
    private String oldBankBranchCode;


}
