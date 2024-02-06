package com.company.NationalPen.service;

import com.company.NationalPen.entity.MaterialEntity;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class NationalPenService {

    private int id = 0;

    private final List<MaterialEntity> materials;

    public NationalPenService() {
        materials = new ArrayList<>();
    }

    public void add() {
        materials.add(new MaterialEntity("Silkscreen", "SS10",
                "Paperles", "LNS-BLK-BLU", 34));
        materials.add(new MaterialEntity("Silkscreen", "SS10",
                "Paperles", "LNS-BLK-BLU", 34));
        materials.add(new MaterialEntity("Silkscreen", "SS10",
                "Paperles", "LNS-BLK-BLU", 34));
    }

    public void addMaterial(MaterialEntity material) {
        id++;
        MaterialEntity materialNP = new MaterialEntity(
                material.getMachineName(), material.getMachineId(),
                material.getViewOrder(), material.getMaterial(),
                material.getQuantity());
        materials.add(materialNP);
    }

    public String delMaterial(int id, String url) {
        materials.removeIf(material -> material.getId().equals(id));
        return url;
    }
}
