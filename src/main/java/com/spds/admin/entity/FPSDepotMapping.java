package com.spds.admin.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Data
@Entity
@Table(schema = "master",name = "fps_depot_mapping")
public class FPSDepotMapping extends Auditable implements Serializable {

    private static final long serialVersionUID = -6329527494545397247L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fps_depot_mapping_seq_id")
    @SequenceGenerator(name = "fps_depot_mapping_seq_id", sequenceName = "fps_depot_mapping_seq_id", schema = "master", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "fps_id")
    private Long fpsId;

    @Column(name = "commodity_id")
    private Long commodityId;

    @Column(name = "district_id")
    private Long districtId;

//  @Column(name = "transport_distance", precision = 10, scale = 2)
    private Double transportDistance;

    @Column(name = "status", length = 200)
    private String status;

    @Column(name = "state_id")
    private Long state_id;



}
