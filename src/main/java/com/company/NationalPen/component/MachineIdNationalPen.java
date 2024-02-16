package com.company.NationalPen.component;

import com.company.NationalPen.repository.NationalPenRepository;
import com.company.NationalPen.writefile.WriteFile;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class MachineIdNationalPen implements NationalPenRepository {

    private final String pathFile = "machine_id.txt";

    private final WriteFile writeFile = new WriteFile(pathFile);

    @Override
    public List<String> getMaterials() {
        return writeFile.loadFile();
    }


}
