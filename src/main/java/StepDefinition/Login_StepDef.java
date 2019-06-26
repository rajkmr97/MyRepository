package StepDefinition;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Utility.BrowserUtility;
import Utility.PropertyFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Login_StepDef{
	WebDriver driver;
	PropertyFile obj= new PropertyFile();

	@Given("User is on Myntra Home Page")
	public void user_is_on_Myntra_Home_Page() throws Throwable {
		
		Properties prop=obj.getProperty();
		driver=BrowserUtility.OpenBrowser(driver, prop.getProperty("browser"), prop.getProperty("url"));
	}
	@When("User Navigate to Login Page")
	public void user_Navigate_to_Login_Page() {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()=\"Profile\"]"))).build().perform();
		WebElement LogIn = driver.findElement(By.xpath("//a[text()=\"log in\"]"));
		LogIn.click();
	 }
	@When("User enters {string} and {string}")
	public void user_enters_and(String user, String pass) {
		
		driver.findElement(By.name("email")).sendKeys(user); 
	    driver.findElement(By.name("password")).sendKeys(pass);
	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	@Then("User successfully Logged in")
	public void user_successfully_Logged_in() {
		driver.quit();
		System.out.println("User Logged in successfully");
   	}
}


