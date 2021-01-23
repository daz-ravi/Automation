package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {
	
	WebDriver driver;
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//ul[@id='mainMenuFirstLevelUnorderedList']/li") 
	List <WebElement> menus;
	
	public void home_page_test()
	{
		int menus_cnt= menus.size();
		for (int i = 0; i < menus_cnt; i++) {
			String menus_txt= menus.get(i).getText();
			System.out.printf("Menu item %d = %s\n",(i+1),menus_txt);
			driver.findElement(By.linkText(menus_txt)).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
