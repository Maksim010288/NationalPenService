package com.company.NationalPen.component;

import com.company.NationalPen.repository.NationalPenRepository;
import lombok.Getter;

import java.util.List;

@Getter
public class MaterialNationalPen implements NationalPenRepository {

    @Override
    public final List<String> getMaterials() {
        return List.of(
                "LNS-BUR-BLK",
                "LNS-BUR-BLU",
                "LNS-WHT-BLK",
                "LNS-WHT-BLU",
                "LMQ-WHT-BLK",
                "LMQ-WHT-BLU",
                "LMQ-RED-BLK",
                "LMQ-RED-BLU"
        );
    }
}
