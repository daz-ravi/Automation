package com.practice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class DemoforMaven {
	
	@Test
	public void testHello()
	{
		System.out.println("Welcome to Maven World");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription="My First ATU Report";
		ATUReports.setAuthorInfo("Ravikumar", Utils.getCurrentTime(), "1.0");
		driver.manage().window().maximize();
		ATUReports.add("Browser window has been maximized successfully", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		driver.get("https://www.google.com/");
		ATUReports.add("Specified URL has been opened successfully", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		System.out.println("Browser Title = "+driver.getTitle());
		ATUReports.add("Browser Title = "+driver.getTitle(), LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}

}
