package general;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Robot_Class {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement search_field=driver.findElement(By.xpath("//input[@title='Search']"));
		search_field.sendKeys("selenium");
		search_field.sendKeys(Keys.ENTER);
		WebElement link = driver.findElement(By.xpath("//span[text()='Selenium WebDriver']"));
		
		Actions action= new Actions(driver);
		action.moveToElement(link).contextClick().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Robot robot= new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			action.moveToElement(link).contextClick().perform();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String parent=driver.getWindowHandle();
		System.out.println("Parent window = "+parent);
		Set<String> window_handles= driver.getWindowHandles();
		for (String win:window_handles) {
			if (!win.equalsIgnoreCase(parent)) {
				driver.switchTo().window(win);
				System.out.println("New WindowHandle = "+win);
				Thread.sleep(4000);
			} 
		}
		driver.switchTo().window(parent);
	}

}
