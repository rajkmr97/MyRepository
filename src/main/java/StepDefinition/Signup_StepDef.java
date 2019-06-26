package StepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Utility.BrowserUtility;
import Utility.PropertyFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Signup_StepDef {
	
	WebDriver driver;
	PropertyFile obj= new PropertyFile();
	
	@Given("User is on the Myntra")
	public void user_is_on_the_Myntra() throws Throwable {
		
		Properties prop=obj.getProperty();
		driver=BrowserUtility.OpenBrowser(driver, prop.getProperty("browser"), prop.getProperty("url"));
	}
	@When("User Opens the Signup Link")
	public void user_Opens_the_Signup_Link() {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[@class='desktop-userTitle' and text()='Profile']"))).build().perform();
		WebElement SignUp = driver.findElement(By.xpath("//a[@class='desktop-linkButton' and text()='Sign up']"));
		SignUp.click();
	}

	@Then("User Enters Email, Name, Mobile Number, and Gender")
	public void user_Enters_Email_Name_Mobile_Number_and_Gender() throws IOException {
		
		InputStream ExcelFileToRead = new FileInputStream("D:\\Testing\\ReadExcel\\Mynthra Signup_data.xlsx");
	    XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
	    XSSFSheet sheet = wb.getSheetAt(0);
	     
	    XSSFCell Email = wb.getSheetAt(0).getRow(1).getCell(0);
	    String email= Email.toString();
	    driver.findElement(By.name("email")).sendKeys(email);
	    
	    XSSFCell Password = wb.getSheetAt(0).getRow(1).getCell(1);
	    String pass= Password.toString();
	    driver.findElement(By.name("password")).sendKeys(pass);
	     
	    XSSFCell PhoneNumber = wb.getSheetAt(0).getRow(1).getCell(2);
	    String Phone= PhoneNumber.getRawValue();
	    driver.findElement(By.name("mobile")).sendKeys(Phone);    
		
	    driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
	  }

	@Then("Clicks the \"([^\"]*)\" Button")
	public void clicks_the_Button(String string) {
		
		WebElement register = driver.findElement(By.xpath("//button[@class='register-register-button' and text()='REGISTER']"));
		boolean RegBtn = register.isEnabled();
		Assert.assertEquals(true, RegBtn);
	    driver.quit();
	    
	    System.out.println("User registered successfully");
	}
}


