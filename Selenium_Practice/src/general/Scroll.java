package general;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.niftytrader.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement link=driver.findElement(By.linkText("5 pharma stocks that more than doubled money in one year"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});", link);
		jse.executeScript("arguments[0].style.border='3px solid red'", link);
	}

}
