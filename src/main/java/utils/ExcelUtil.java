/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Son
 */
public class ExcelUtil {
    public static <T> List<T> readExcelData(String filePath,int sheet ,Class<T> clazz) {
        List<T> dataList = new ArrayList<>();
        try ( FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);){
            Sheet datatypeSheet = workbook.getSheetAt(sheet);
            Iterator<Row> iterator = datatypeSheet.iterator();
            // Skip header row
            if (iterator.hasNext()) {
                iterator.next();
            }
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                T data = clazz.getDeclaredConstructor().newInstance();
                int cellIndex = 0;
                for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Cell cell = currentRow.getCell(cellIndex++);
                if (cell != null) {
                    if (field.getType() == int.class) {
                        
                        if (cell.getCellType() == CellType.NUMERIC) {
                            System.out.println(cell.getNumericCellValue());
                            field.set(data, (int) cell.getNumericCellValue());
                        } else if (cell.getCellType() == CellType.STRING) {
                            System.out.println(Integer.valueOf(cell.getStringCellValue()));
                            field.set(data, Integer.valueOf(cell.getStringCellValue()));
                        }
                    } else if (field.getType() == String.class) {
                            field.set(data, cell.getStringCellValue());
                    } else if (field.getType() == LocalDateTime.class) {
                        // Handle LocalDateTime type if needed
                    }
                }
                }
                dataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
