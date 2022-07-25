package dataproviderUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class dataproviderRead {
	static FileInputStream fs;
	static XSSFSheet sh;
	static XSSFWorkbook  wb;
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			 fs = new FileInputStream(fileName);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		try {
			 wb = new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();
			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 0 ; i <totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i][j] = sh.getRow(i).getCell(j).toString();
				}

			}
		
		return arrayExcelData;
	}
}
