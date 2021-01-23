package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Login_Page {
	
	WebDriver driver;
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="txtUsername") 
	WebElement username;

	@FindBy(how=How.ID,using="txtPassword") 
	WebElement password;

	@FindBy(how=How.ID,using="btnLogin") 
	WebElement login_btn;
	
	public void login_test(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login_btn.click();
		try {
			WebElement invalid_cred= driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
			if (invalid_cred.isDisplayed()) {
				Assert.assertTrue(false, "Invalid Credentials have been entered");
			}
		} catch (Exception e) {
			String exception_message=e.getMessage().toLowerCase();
			if (exception_message.contains("unable to locate element")) {
				System.out.println("Exception message = "+exception_message);
				Assert.assertTrue(true, "Correct Credentials have been entered");
			}
			
		}
	}
}
