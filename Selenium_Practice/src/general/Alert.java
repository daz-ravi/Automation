package general;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement search= driver.findElement(By.xpath("//button[contains(@class,'btn-booking')]"));
		search.click();
		Thread.sleep(2000);
		String alert_text=driver.switchTo().alert().getText();
		System.out.println("Alert text = "+alert_text);
		driver.switchTo().alert().accept();
		
		Actions action= new Actions(driver);
		action.moveToElement(search).click().perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
	}

}
