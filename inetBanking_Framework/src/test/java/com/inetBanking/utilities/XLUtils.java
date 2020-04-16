package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.*;

public class XLUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fout;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String filePath, String sheetName) throws Exception {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public static int getCellCount(String filePath, String sheetName,int rowNum) throws Exception{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
				 		
		}
	
	public static String getCellData(String filePath, String sheetName,int rowNum, int cellNum) throws Exception {
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String cellData = cell.toString();
		wb.close();
		fis.close();
		return cellData;
		
	}
	
	public static void setCellData(String filePath, String sheetName,int rowNum, int cellNum, String data) throws Exception{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		cell.setCellValue(data);
		fout = new FileOutputStream(filePath);
		wb.write(fout);
		wb.close();
		fis.close();
		fout.close();
		
	}
	
	

}
