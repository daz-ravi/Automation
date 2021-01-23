package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main_Script {
	
	Wrapper wp = new Wrapper();
	WebDriver driver;
	
	@Test(dataProvider="data")
	public void execute_Tests(String browser, String url, String uname, String pwd)
	{
		driver=wp.browser_launch(browser, url);
		Login_Page lp= PageFactory.initElements(driver, Login_Page.class);
		lp.login_test(uname, pwd);
		Home_Page hp= PageFactory.initElements(driver, Home_Page.class);
		hp.home_page_test();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="data")
	public String[][] getData()
	{
		String[][] exceldata=wp.getxls("Sheet1");
		return exceldata;
	}
	
}
