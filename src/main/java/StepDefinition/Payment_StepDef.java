package StepDefinition;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
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
public class Payment_StepDef {
	
	WebDriver driver;
	PropertyFile obj= new PropertyFile();
	
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() throws Throwable {
		
		Properties prop=obj.getProperty();
		driver=BrowserUtility.OpenBrowser(driver, prop.getProperty("browser"), prop.getProperty("url"));
	}

	@When("user selects a particular product")
	public void user_selects_a_particular_product() {
		
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("Suits");
		driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite desktop-iconSearch sprites-search\"]")).click();
	}

	@Then("user bags the selected product")
	public void user_bags_the_selected_product() {
	    
		Actions act =  new Actions(driver);
		String basWin = driver.getWindowHandle();
	       
	       // Locate 'Click to open a new browser window!'
	    WebElement newWindowBtn = driver.findElement(By.xpath("//div[@class='product-productMetaInfo'][1]"));
	    newWindowBtn.click();
	    Set<String> winHandles = driver.getWindowHandles();
	       // Loop through all Window handles
	    for(String handle: winHandles)
	    {
	    	if(!handle.equals(basWin))
	        {
	    		driver.switchTo().window(handle);
	        	  	   
	        	driver.findElement(By.cssSelector("#sizeButtonsContainer > div.size-buttons-size-buttons > div:nth-child(1) > div.size-buttons-buttonContainer > button > p")).click();
	        	WebElement Add_To_Bag = driver.findElement(By.xpath("//*[@class=\"pdp-add-to-bag pdp-button pdp-flex pdp-center\" and text()=\"ADD TO BAG\"]"));
	            Add_To_Bag.click();
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	               
	            //Buy product in the cart
	            WebElement Go_To_Cart = driver.findElement(By.xpath("//*[text()='GO TO BAG']"));
	            Go_To_Cart.click();
	            WebElement Place_Order = driver.findElement(By.xpath("//*[text()=\"Place Order\"]"));
	            Place_Order.click();
	               
	            driver.quit();
	            System.out.println("Product ordered successfully");
	          }
	       }
	    }
	}


