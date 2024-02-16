package com.company.NationalPen.exelfile;

import com.company.NationalPen.entity.MaterialEntity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
@Component
public class WorkBookExel {

    long index = 0;
    private final Workbook workbook = new XSSFWorkbook();
    private final Sheet sheet = workbook.createSheet("newFile");


    private CellStyle styleRove() {
        sheet.autoSizeColumn(20, true);
        CellStyle style = workbook.createCellStyle();
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
        return style;
    }

    private XSSFFont xssfFont() {
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setFontName("Ariel");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        return font;
    }

    public void createFile(MaterialEntity materialEntity) {
        CellStyle style = styleRove();
        Row row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Machine name");
        row1.createCell(1).setCellValue("Machine id");
        row1.createCell(2).setCellValue("View order");
        row1.createCell(3).setCellValue("Material");
        row1.createCell(4).setCellValue("Quantity");
        Cell cell;
        for (int i = 0; i < 5; i++) {
            cell = row1.getCell(i);
            sheet.setColumnWidth(i, 5000);
            cell.setCellStyle(style);
            style.setFont(xssfFont());
        }
        addNewRow(materialEntity);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("write.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addNewRow(MaterialEntity material) {
        index++;
        Row row2 = sheet.createRow((int) index);
        row2.createCell(0).setCellValue(material.getMachineName());
        row2.createCell(1).setCellValue(material.getMachineId());
        row2.createCell(2).setCellValue(material.getViewOrder());
        row2.createCell(3).setCellValue(material.getMaterial());
        row2.createCell(4).setCellValue(material.getQuantity());
    }
}
