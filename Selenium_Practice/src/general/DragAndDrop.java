package general;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement src= driver.findElement(By.xpath("//span[text()='Learning DHTMLX Suite UI']"));
		WebElement dest= driver.findElement(By.xpath("//li[text()='Zend Framework in Action']"));
		
		JavascriptExecutor jse=(JavascriptExecutor)driver; 
		jse.executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});", src);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].style.border='3px solid red'", src);
		Actions action= new Actions(driver);
		action.dragAndDrop(src, dest).perform();
		
		
	}

}
