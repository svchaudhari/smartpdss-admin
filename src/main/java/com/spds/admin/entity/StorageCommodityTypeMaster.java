package com.spds.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


/**
 * @author @muhammadtalib
 * created 10/01/2025
 */

@Data
@Entity
@Table(name = "storage_commodity_type_master", schema = "master")
public class StorageCommodityTypeMaster extends Auditable implements Serializable {

    private static final long serialVersionUID = 1645859286028256583L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "storage_commodity_type_master_seq_id")
    @SequenceGenerator(name = "storage_commodity_type_master_seq_id" , sequenceName = "storage_commodity_type_master_seq_id" , schema = "master" ,allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "storage_commodity")
    private String storageCommodity;
}
