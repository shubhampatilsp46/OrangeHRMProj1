package dataproviderUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public static XSSFWorkbook wk;
	
public ExcelDataProvider() 
{
	try {
	FileInputStream path=new FileInputStream("C:\\Users\\Neosoft\\eclipse-workspace\\OrangeHRMProj1\\TestData\\LoginPageTestData.xlsx");
	 wk=new XSSFWorkbook(path);
}
catch(Exception e)
{
	System.out.println("Unable to open file"+e.getMessage());
}
}
public String getStringData(String sheetName,int row,int col)
{
	return wk.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
}
public String getStringData(int sheetName,int row,int col)
{
	return wk.getSheetAt(sheetName).getRow(row).getCell(col).getStringCellValue();
}
public  double getNumericData(String sheetName,int row,int col)
{
	return wk.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
}
public  double getNumericData(int sheetName,int row,int col)
{
	return wk.getSheetAt(sheetName).getRow(row).getCell(col).getNumericCellValue();
}
}
