package com.company.NationalPen.component;

import com.company.NationalPen.repository.NationalPenRepository;
import lombok.Getter;

import java.util.List;
@Getter
public class DepartmentsNationalPen implements NationalPenRepository {

    @Override
    public List<String> getMaterials() {
        return List.of(
                "Silkscreen",
                "SilkScreen_bag",
                "Pad Print",
                "Mimaki"
        );
    }
}
