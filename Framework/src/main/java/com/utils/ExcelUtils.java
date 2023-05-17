package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static final String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + "//src/test//resources//testdataframe.xlsx";
	static String excelPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fs;
	static File file = new File(filePath);

	public ExcelUtils() throws IOException {

		try {
			workbook = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheetAt(0);
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;

	}

	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;

	}

	public static String readStringData(String sheetname, int rowNum, int colNum) throws IOException {

		String cellValue = sheet.getRow(rowNum - 1).getCell(colNum - 1).getStringCellValue();
		return cellValue;
	}

	public static int readIntegerData(String sheetname, int rowNum, int colNum) throws IOException {
		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetname);
		int cellValue = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

		return cellValue;
	}

}