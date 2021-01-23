package excelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Read_Excel {

	@Test
	void readExcel()
	{
		//This is to read excel file
		//Added comments as last attempt
		String [][] excel_data= null;
		File src= new File("./Data_Folder/HRM_Data.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			try {
				XSSFWorkbook wb= new XSSFWorkbook(fis);
				XSSFSheet ws= wb.getSheet("Sheet1");
				int rows= ws.getLastRowNum();
				int columns= ws.getRow(1).getLastCellNum();
				
				System.out.printf("Total rows count = %d and Total columns count = %d\n",rows,columns);
				
				excel_data= new String[rows][columns];
				
				for (int i = 0; i < rows; i++) {
					
					for (int j = 0; j < columns; j++) {
						
						String txt= ws.getRow(i+1).getCell(j).getStringCellValue();
						System.out.printf("Cell text at row %d column %d = %s\n",(i+1),(j+1),txt);
						excel_data[i][j]=txt;
					}
				}
				
				for (int i = 0; i < rows; i++) {
					
					for (int j = 0; j < columns; j++) {
						
						String array_value=excel_data[i][j];
						System.out.printf("Array value at (%d,%d) = %s\n",i,j,array_value);
					}
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
