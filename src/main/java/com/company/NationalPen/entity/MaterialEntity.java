package com.company.NationalPen.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "national_pen")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "machine_name")
    private String machineName;
    @Column(name = "machine_id")
    private String machineId;
    @Column(name = "view_order")
    private String viewOrder;
    @Column(name = "materials")
    private String material;
    @Column(name = "quantity")
    private Integer quantity;

    public MaterialEntity(){}

    public MaterialEntity(Integer id, String machineName, String machineId, String viewOrder, String material, Integer quantity) {
        this.id = id;
        this.machineName = machineName;
        this.machineId = machineId;
        this.viewOrder = viewOrder;
        this.material = material;
        this.quantity = quantity;
    }

    public MaterialEntity(String machineName, String machineId, String viewOrder, String material, Integer quantity) {
        this.machineName = machineName;
        this.machineId = machineId;
        this.viewOrder = viewOrder;
        this.material = material;
        this.quantity = quantity;
    }
}
