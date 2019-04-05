package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtils {

	private static HSSFWorkbook excelWBook;
	private static HSSFSheet sheet;
	private static HSSFRow row;
	private static HSSFCell cell;
	private static DataFormatter formatter;

	// metoda za uèitavanje excel fajla
	public static void getExcelFile(String path, String sheetName) throws Exception {
		try {
			FileInputStream excelFile = new FileInputStream(Constant.path+Constant.data);
			excelWBook = new HSSFWorkbook(excelFile);
			sheet = excelWBook.getSheet(sheetName);
			formatter = new DataFormatter();
		} catch (Exception e) {
			throw (e);
		}
	}

	// metoda za ispis sadržaja æelije
	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = sheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}
	
	//Metoda za upis u excel tabelu
	public static void setCellData(String result, int rowNum, int colNum) throws Exception {
		try {

			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}

			FileOutputStream fileOut = new FileOutputStream(Constant.path+Constant.data);
			excelWBook.write(fileOut);

			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			throw (e);

		}

	}

	public static HSSFSheet getExcelSheet() {
		return sheet;
	}
}
