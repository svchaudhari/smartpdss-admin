package com.spds.admin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@Data
@Entity
@Table(name = "depot_master", schema = "master")
public class DepotMaster extends Auditable implements Serializable {

    private static final long serialVersionUID = 2246598814462157636L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depot_master_seq_id")
    @SequenceGenerator(name = "depot_master_seq_id", sequenceName = "depot_master_seq_id", schema = "master", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "old_depot_id")
    private Long oldDepotId;

    @Column(name = "depot_name_en", length = 99)
    private String depotNameEN;

    @Column(name = "depot_name_ll", length = 150)
    private String depotNameLL;

    @Column(name = "contact_person_name_en", length = 99)
    private String contactPersonNameEN;

    @Column(name = "contact_person_name_ll", length = 150)
    private String contactPersonNameLL;

    @Column(name = "depot_mobile_no", length = 10)
    private String depotMobileNo;

    @Column(name = "depot_landline_no", length = 15)
    private String depotLandlineNo;

    @Column(name = "depot_fax_no", length = 15)
    private String depotFaxNo;

    @Column(name = "depot_email_id", length = 150)
    private String depotEmailID;

    @Column(name = "depot_longitude", length = 15)
    private String depotLongitude;

    @Column(name = "depot_latitude", length = 15)
    private String depotLatitude;

    @Column(name = "state_id", length = 2)
    private Long stateId;

    @Column(name = "district_id", length = 3)
    private Long districtId;

    @Column(name = "tahsil_id", length = 5)
    private Long tahsilId;

    @Column(name = "village_id", length = 16)
    private Long villageId;

    @Column(name = "depot_address1", length = 100)
    private String depotAddress1;

    @Column(name = "depot_address2", length = 50)
    private String depotAddress2;

    @Column(name = "pin_code", length = 6)
    private String pinCode;

    @Column(name = "distance_to_hq")
    private Long distanceToHQ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "application_date")
    private LocalDateTime applicationDate;

    @Column(name = "predominant_commodity_type", length = 2)
    private String predominantCommodityType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "capacity_effective_from_date")
    private LocalDateTime capacityEffectiveFromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "capacity_effective_to_date")
    private LocalDateTime capacityEffectiveToDate;

    @Column(name = "covered_capacity")
    private Double coveredCapacity;

    @Column(name = "covered_capacity_unit", length = 2)
    private String coveredCapacityUnit;

    @Column(name = "scientific_open")
    private Double scientificOpen;

    @Column(name = "scientific_open_unit", length = 2)
    private String scientificOpenUnit;

    @Column(name = "non_scientific_open")
    private Double nonScientificOpen;

    @Column(name = "non_scientific_open_unit", length = 2)
    private String nonScientificOpenUnit;

    @Column(name = "silo_capacity")
    private Double siloCapacity;

    @Column(name = "silo_capacity_unit", length = 2)
    private String siloCapacityUnit;

    @Column(name = "storage_commodity_type_id", length = 10)
    private Long storageCommodityTypeId;

    @Column(name = "storage_type_id", length = 10)
    private Long storageTypeId;

}
