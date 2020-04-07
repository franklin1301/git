package com.datadriven.datadriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDtask {
//**********************************to get particular cell************************************************************************************
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\exceldata\\Book2.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		System.out.println(lastRowNum);

		int column = 0, row1 = 0;
				
		System.out.println("**********************printing columns************************************************************************");
		for (int i = 0; i <= lastRowNum; i++) {
			Row row = sheetAt.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 1; j < physicalNumberOfCells; j++) {
				String stringCellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
				if (stringCellValue.equalsIgnoreCase("darbar")) {
					row1 = i;
					column = j;
				}}
			System.out.println(sheetAt.getRow(i).getCell(column).getStringCellValue());

		}
//***************************************************to get row******************************************************************
		System.out.println("*********************************************printing rows *********************************************");
		for (int i = row1; i <= row1; i++) {
			Row row = sheetAt.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				String stringCellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);

			}

		}

	}

}
