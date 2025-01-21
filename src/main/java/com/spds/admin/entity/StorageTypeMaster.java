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
@Table(name = "storage_type_master", schema = "master")
public class StorageTypeMaster extends Auditable implements Serializable {

    private static final long serialVersionUID = -5863489708055608964L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_type_master_seq_id")
    @SequenceGenerator(name = "storage_type_master_seq_id" , sequenceName = "storage_type_master_seq_id" , schema = "master" , allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "storage_type_name")
    private String storageTypeName;
}
