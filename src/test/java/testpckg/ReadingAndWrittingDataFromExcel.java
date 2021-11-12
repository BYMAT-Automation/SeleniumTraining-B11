package testpckg;

import co.in.bymat.seleniumTraining.ExcelReader;

public class ReadingAndWrittingDataFromExcel {
	
	public static void main(String[] args) {
		
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		//System.out.println("Column Count is:- " + excel.getColumnCount("Test_data"));
		
		//System.out.println("Row Count is:- " + excel.getRowCount("Test_data"));
		
	//	excel.addColumn("Test_data", "NewColumn");
		
		//excel.addSheet("NewSheet");
		
//		System.out.println(excel.getCellData("Test_data", 2, 4));
//		
//		System.out.println(excel.getCellData("Test_data", 4, 5));
//		
//		System.out.println(excel.getCellData("Test_data", "Name", 6));
//		
//		System.out.println(excel.getCellData("Test_data", "City", 2));
		
		
		excel.setCellData("Test_data", "Name", 2, "Rahul Ganjare");
	
		
	}

}
