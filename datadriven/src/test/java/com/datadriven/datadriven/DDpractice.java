package com.datadriven.datadriven;

import practicedd.datadrivenlib;

public class DDpractice {
	public static void main(String[] args) {
		datadrivenlib data = new datadrivenlib();

		data.file("C:\\exceldata\\Book1.xlsx"); // calling with object name so remove static in method
		System.out.println("******************************************particular column***************************************************************");

		data.fileAllRowsParticularColumn(0, 0);

		System.out.println("*************************************particular row*************************************************************");

		data.fileParticularRow(0, 8);
		
		System.out.println("************************************particular cell*************************************************************");
		
		String fileParticularCell = data.fileParticularCell(0, 8, 1);
		System.out.println(fileParticularCell);

		System.out.println("**********************************read all cell****************************************************************");
		
		data.fileReadAll(0, "C:\\\\exceldata\\\\Book1.xlsx");
	}
}
