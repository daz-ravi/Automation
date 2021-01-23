package pageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wrapper {
	
	WebDriver driver;
	
	public WebDriver browser_launch(String browser, String url)
	{
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String[][] getxls(String sheetname)
	{
		String[][] excel_data=null;
		
		File src= new File("./Data_Folder/HRM_Data.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			try {
				XSSFWorkbook wb= new XSSFWorkbook(fis);
				XSSFSheet ws= wb.getSheet(sheetname);
				
				int rows= ws.getLastRowNum();
				int columns= ws.getRow(1).getLastCellNum();
				excel_data= new String[rows][columns];
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < columns; j++) {
						String txt= ws.getRow(i+1).getCell(j).getStringCellValue();
						System.out.printf("Excel data at row '%d' column '%d' = %s\n",(i+1),j,txt);
						excel_data[i][j]=txt;
					}
				}
				
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < columns; j++) {
						String cell_txt= excel_data[i][j];
						System.out.printf("Cell data at (%d,%d) = %s\n",i,j,cell_txt);
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
		return excel_data; 
	}
	

}
