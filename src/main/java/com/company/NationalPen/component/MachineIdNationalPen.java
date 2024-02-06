package com.company.NationalPen.component;

import com.company.NationalPen.repository.NationalPenRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
@Getter
public class MachineIdNationalPen implements NationalPenRepository {
    private final Properties properties = new Properties();

    public MachineIdNationalPen() {
        try {
            FileInputStream fileInputStream = new FileInputStream("m.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> machineId() {
        return getMaterials();
    }

    @Override
    public List<String> getMaterials() {
        List<String> machineId = new ArrayList<>(List.of());
        for (int i = 1; i <= properties.size(); i++) {
            machineId.add(properties.getProperty(String.valueOf(i)));
        }
        return machineId;
    }
}
