package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {
	
	
	public static WebDriver OpenBrowser(WebDriver driver,String browser,String url) throws InterruptedException
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;	
		}else if(browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
			    driver = new FirefoxDriver();
			    driver.manage().window().maximize();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return driver;
			    
		}
		return null;
	}
}


