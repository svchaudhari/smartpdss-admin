package com.spds.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(schema ="master",name = "commodity_master")
public class CommodityMaster extends Auditable implements Serializable {

    private static final long serialVersionUID = -4673098336671583764L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commodity_master_seq_id")
    @SequenceGenerator(name = "commodity_master_seq_id", sequenceName = "commodity_master_seq_id", schema = "master", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "commodity_name",length =100)
    private String commodityName;
}
