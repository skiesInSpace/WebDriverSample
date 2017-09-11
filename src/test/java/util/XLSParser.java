package util;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XLSParser {


    public Map<String, Integer> parse(File file, int sheetNumber) {


        XSSFWorkbook wb = null;
        Map<String, Integer> map = new HashMap<>();
        try ( InputStream in = new FileInputStream(file)){

            wb = new XSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(sheetNumber);

        Iterator<Row> it = sheet.iterator();

        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cellIterator = row.iterator();

            Cell currentCell = cellIterator.next();
            String key = currentCell.getStringCellValue();

            currentCell = cellIterator.next();
            Integer value = (int) currentCell.getNumericCellValue();

            map.put(key, value);

        }

        return map;
    }

}

