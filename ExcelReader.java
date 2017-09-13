package opusAutomationexcelReader;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader{
	
	
	public String ReadExcel(String SheetName , int RowNum , int colNum)  throws Exception 
	{
	
	File src = new File("C:\\WorkSpace\\OPUSAutomation\\Data\\TestData.xlsx");

	FileInputStream fis = new FileInputStream(src);
	
	XSSFWorkbook xw = new XSSFWorkbook(fis);
	
	XSSFSheet sh1 = xw.getSheet(SheetName);
	
	String Value = sh1.getRow(RowNum).getCell(colNum).getStringCellValue();
	
	return Value;
	
	
	
	
	}
	
	
}
