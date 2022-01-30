package utils;

import constants.FrameworkConstants;
import exceptions.InvalidFilePathException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class ExcelUtil {

    private ExcelUtil(){}

    
    public static Object[][] getData(String sheetName){
    	String[][] excelData = null;
    	try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelFilePath());) {
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();
            excelData=new String[rowNum][colNum];
            for(int i=1;i<=rowNum;i++){                
                for(int j=0;j<colNum;j++) {
                	excelData[i-1][j]=sheet.getRow(i).getCell(j).toString();
                }
            }
        } catch (FileNotFoundException e) {
            throw new InvalidFilePathException("File not found. Please check the file name mentioned in Line:22",e);
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        return excelData;
    }
}
