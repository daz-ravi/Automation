package general;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrap {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/bootstrap4/bootstrap_dropdowns.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dropdown1= driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
		dropdown1.click();
		List<WebElement> links= driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
		int links_cnt= links.size();
		System.out.println("Links count = "+links_cnt);
		for(WebElement txt:links)
		{
			System.out.println("Link text = "+txt.getText());
		}
	}

}
