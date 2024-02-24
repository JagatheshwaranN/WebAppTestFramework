package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelReader {

    String filePath;
    Sheet sheet;
    Workbook workbook = null;

    public ExcelReader(String sheetName){
        try{
            filePath = System.getProperty("user.dir")+FileReader.getDataFromPropFile("testDataPath");
            File testDataFile = new File(filePath);
            workbook = WorkbookFactory.create(testDataFile);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, String> getTestDataFromExcelAsMap(int rowNum) {
        HashMap<String, String> excelTestDataMap = new HashMap<>();
        for(int i = 0; i < sheet.getRow(0).getLastCellNum(); i++){
            String value;
            Cell cell = sheet.getRow(rowNum).getCell(i);
            if(cell != null){
                cell.setCellType(CellType.STRING);
                value = cell.toString();
            }else {
                value = "";
            }
            excelTestDataMap.put(sheet.getRow(0).getCell(i).toString(), value);
        }
        return excelTestDataMap;
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }

}
