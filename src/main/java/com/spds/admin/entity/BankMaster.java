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
@Table(schema = "master", name = "bank_master")
public class BankMaster extends Auditable implements Serializable {


    private static final long serialVersionUID = -23627826328507417L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_master_seq_id")
    @SequenceGenerator(name = "bank_master_seq_id", sequenceName = "bank_master_seq_id", schema = "master", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "bank_name_en", length = 99)
    private String bankNameEn;

    @Column(name = "bank_type", length = 60)
    private String bankType;

    @Column(name = "head_quater_house_name_no_en", length = 60)
    private String headQuaterHouseNameNoEn;

    @Column(name = "head_quater_landmark_en", length = 60)
    private String headQuaterLandmarkEn;

    @Column(name = "head_quater_village_town_name_en", length = 50)
    private String headQuaterVillageTownNameEn;

    @Column(name = "head_quater_tehsil_tahluk_subdistrict_name_en", length = 50)
    private String headQuaterTehsilTahlukSubdistrictNameEn;

    @Column(name = "head_quater_district_name_en", length = 50)
    private String headQuaterDistrictNameEn;

    @Column(name = "head_quater_state_name_en", length = 50)
    private String headQuaterStateNameEn;

    @Column(name = "head_quater_postal_pin", length = 6)
    private String headQuaterPostalPin;

    @Column(name = "bank_name_ll", length = 99)
    private String bankNameLl;

    @Column(name = "display_sno", length = 50)
    private Integer displaySno;

    @Column(name = "bank_short_name", length = 4)
    private String bankShortName;

    @Column(name = "active", length = 1)
    private char active;

    @Column(name = "generic_bank_code", length = 4)
    private String genericBankCode;

    @Column(name = "associated_of", length = 3)
    private String associatedOf;

    @Column(name = "core_banking_facility_of", length = 3)
    private String coreBankingFacilityOf;

    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "max_acc_length")
    private Integer maxAccLength;

    @Column(name = "min_acc_length")
    private Integer minAccLength;

    @Column(name = "treasury_bank_code")
    private Integer treasuryBankCode;

    @Column(name = "national_or_state_type", length = 1)
    private char nationalOrStateType;

    @Column(name = "state_id", length = 2)
    private String stateId;


}
