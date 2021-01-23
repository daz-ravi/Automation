package general;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HttpConnection {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		int links_cnt= links.size();
		System.out.println("Total links = "+links_cnt);
		
		for (int i = 0; i < links_cnt; i++) {
			String link=links.get(i).getAttribute("href");
			System.out.println("Captured URL = "+link);
			val(link);
		}
		
	}
	
	public static void val(String taglink)
	{
		try {
			URL url = new URL(taglink);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(3000);
			con.connect();
			System.out.println(url+" => "+con.getResponseMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
