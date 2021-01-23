package general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://digs-uat.umusic.net/");
		
		Runtime.getRuntime().exec("./AutoIT/WinPopup.exe");
		Thread.sleep(3000);
		System.out.println("Current thread name = "+Thread.currentThread().getName());
		
		
		//driver.quit();
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1= new FirefoxDriver();
		driver1.manage().window().maximize();
		driver1.get("http://digs-uat.umusic.net/");
		
		Runtime.getRuntime().exec("./AutoIT/WinPopup.exe");
		
		Thread.sleep(3000);
		System.out.println("Current thread name = "+Thread.currentThread().getName());
		//driver1.quit();
	}

}
