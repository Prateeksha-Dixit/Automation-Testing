package com.wp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	
	@Test
	public void readCredentials_First() throws IOException {
		
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\Prateeksha Dixit\\Desktop\\Book2.xlsx"));
		XSSFWorkbook  workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		
		XSSFRow row=sheet.getRow(0);
		String firstCell=row.getCell(0).getStringCellValue();
		System.out.println(firstCell);
		
	}

}
