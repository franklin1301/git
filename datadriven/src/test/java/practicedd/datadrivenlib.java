package practicedd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadrivenlib {
static Workbook wb;
static String stringCellValue;
	public void file(String pathname) {
		try {
			File file = new File(pathname);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void fileReadAll(int sheetnumber,String pathname) {
		/*
		 * Sheet sheetAt = wb.getSheetAt(sheetnumber); int lastRowNum =
		 * sheetAt.getLastRowNum(); for (int i = 0; i <=lastRowNum; i++) { Row row =
		 * sheetAt.getRow(i); int physicalNumberOfCells =
		 * row.getPhysicalNumberOfCells(); for (int j = 0; j <=physicalNumberOfCells;
		 * j++) { stringCellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
		 * System.out.println(stringCellValue);
		 */
		XSSFWorkbook wb;
		try {
			File file = new File(pathname);

			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheetAt = wb.getSheetAt(0);

		int lastRowNum = sheetAt.getLastRowNum();
		System.out.println(lastRowNum);
		for (int i = 0; i <= lastRowNum; i++) {
			XSSFRow row = sheetAt.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				String stringCellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
			}
		}	}catch (Exception e) {
				System.out.println(e.getMessage());
			
			
		}
	
		
	}
	
	public String fileParticularCell(int sheetnumber,int rownumber,int cellnum) {
		Sheet sheetAt = wb.getSheetAt(sheetnumber);
		String stringCellValue = sheetAt.getRow(rownumber).getCell(cellnum).getStringCellValue();
		return stringCellValue;
		}
	
	public void fileAllRowsParticularColumn(int sheetnumber,int j) {
		Sheet sheetAt = wb.getSheetAt(sheetnumber);
		int lastRowNum = sheetAt.getLastRowNum();
		for (int i = 0; i <=lastRowNum ; i++) {
			stringCellValue = sheetAt.getRow(i).getCell(j).getStringCellValue();
			System.out.println(stringCellValue);
		}

	}
	
	public void fileParticularRow(int sheetNum,int rownum) {
		Sheet sheetAt = wb.getSheetAt(sheetNum);
		Row row = sheetAt.getRow(rownum);
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		for (int i = 0; i < physicalNumberOfCells; i++) {
		String stringCellValue2 = sheetAt.getRow(rownum).getCell(i).getStringCellValue();
		System.out.println(stringCellValue2);
		
	}
		
	}
	
	public datadrivenlib() {
		
	}
}

