package general;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Xpath {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@href,'dash')]")).click();
		Thread.sleep(1000);
		String legend=driver.findElement(By.xpath("//div[@id='div_legend_pim_employee_distribution_legend']//td[contains(text(),'Not')]")).getText();
		System.out.println("Legend Text 1 = "+legend);
		
		// To fetch and add preceding menu items 
		List<WebElement> preceding_menus=driver.findElements(By.xpath("//a[@id='menu__Performance']//preceding::li[@class='main-menu-first-level-list-item']/a"));
		int preceding_cnt=preceding_menus.size();
		String[] preceding_menu_items=new String[preceding_cnt];
		System.out.println("Preceding menus count = "+preceding_cnt);
		for (int i = 0; i < preceding_cnt; i++) {
			String menu_txt=preceding_menus.get(i).getText();
			System.out.printf("Preceding menus text at index %d = %s\n",i,menu_txt);
			preceding_menu_items[i]=menu_txt;
		}
		
		// To fetch and add following menu items
		List<WebElement> following_menus=driver.findElements(By.xpath("//a[@id='menu__Performance']//following::li[@class='main-menu-first-level-list-item']/a"));
		int following_cnt=following_menus.size();
		System.out.println("Total menu items following = "+following_cnt);
		String[] following_menu_items=new String[following_cnt];
		
		for (int i = 0; i < following_cnt; i++) {
			String menu_txt=following_menus.get(i).getText();
			System.out.printf("Following menus text at index %d = %s\n",i,menu_txt);
			following_menu_items[i]=menu_txt;
		}
		
		//Loop to get menu items preceding Performance menu item
		for (int i = 0; i < preceding_cnt; i++) {
			String menu_txt=preceding_menu_items[i];
			System.out.printf("Menu item from array at index %d = %s\n",i,menu_txt);
			driver.findElement(By.linkText(menu_txt)).click();
			Thread.sleep(1000);
		}
		
		//Loop to get menu items following Performance menu item
		for (int i = 0; i < following_cnt; i++) {
			String menu_txt=following_menu_items[i];
			System.out.printf("Menu item from array at index %d = %s\n",i,menu_txt);
			driver.findElement(By.linkText(menu_txt)).click();
			Thread.sleep(1000);
		}
		
	}

}
