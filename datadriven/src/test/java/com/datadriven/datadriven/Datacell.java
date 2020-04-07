package com.datadriven.datadriven;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datacell {
public static void main(String[] args) throws Exception {
	File f = new File("C:\\exceldata\\Book1.xlsx");
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet sheetAt = wb.getSheetAt(0);
	int lastRowNum = sheetAt.getLastRowNum();
	System.out.println(lastRowNum);
	for (int i = 0; i <=lastRowNum; i++) {
		
		Row row = sheetAt.getRow(i);
		
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		System.out.println(physicalNumberOfCells);
		for (int j = 0; j < physicalNumberOfCells; j++) {
			
			String stringCellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
			System.out.println(stringCellValue);
		}
	}
	
	wb.close();
}
}
