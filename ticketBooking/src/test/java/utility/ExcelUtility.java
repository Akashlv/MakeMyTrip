
package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	File inputFile = new File(System.getProperty("user.dir").concat("\\src\\test\\resources\\testData\\testData.xlsx"));

	public String getCellValue(int Sheet, int Row, int Column) throws IOException {

		FileInputStream fs = new FileInputStream(inputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(Sheet);
		return sheet.getRow(Row).getCell(Column).toString();
	}

}