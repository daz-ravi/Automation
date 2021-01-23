package general;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.niftytrader.in/");
		
		WebElement forex=driver.findElement(By.xpath("//*[@class='h_subheading black_heading']"));
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(forex));
		
		boolean status=forex.isDisplayed();
		
		if (status) {
			System.out.println("Forex is Displayed");
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});", forex);
		} else {
			System.out.println("Forex is not Displayed");
		}
	}

}
