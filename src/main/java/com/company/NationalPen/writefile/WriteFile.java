package com.company.NationalPen.writefile;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public class WriteFile {

    private final File file;

    public WriteFile(String files) {;
        this.file = new File(files);
    }

    public List<String> loadFile() {
        String line;
        List<String> listLines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null ) {
                String[] lines = line.split(",");
                Collections.addAll(listLines, lines);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listLines;
    }

}
