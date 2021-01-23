package testNG_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	@Test(groups= {"sanity"})
	void from_Test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Launched");
		driver.get("https://www.google.com/");
		System.out.println("URL Entered");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Current Window Title = "+driver.getTitle());
		System.out.println("Page Title Fetched");
		System.out.println("From Test1");
		driver.quit();
	}
	
}
