package com.datadriven.datadriven;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\exceldata\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis); // for xlsx

		XSSFSheet sheetAt = wb.getSheetAt(0);

		int lastRowNum = sheetAt.getLastRowNum();
		System.out.println(lastRowNum);
		for (int i = 0; i <= lastRowNum; i++) {
			XSSFRow row = sheetAt.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				String stringCellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
			}}wb.close();
	}}
