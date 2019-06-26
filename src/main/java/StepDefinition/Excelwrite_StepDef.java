package StepDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
public class Excelwrite_StepDef {
	WebDriver driver;
	PropertyFile obj= new PropertyFile();
	
	@Given("user is on Myntra home page")
	public void user_is_on_Myntra_home_page() throws Throwable {
		Properties prop=obj.getProperty();
		driver=BrowserUtility.OpenBrowser(driver, prop.getProperty("browser"), prop.getProperty("url"));
	}
	@When("user navigates to product details info page")
	public void user_navigates_to_product_details_info_page() {
		
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("Belts");
		driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite desktop-iconSearch sprites-search\"]")).click();
	}
	@Then("Writing details into excel sheet")
	public void writing_details_into_excel_sheet() throws IOException, Throwable {
		
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sht = work.createSheet("Belts");
		//product details
		String pageXpath[]= {"pdp-title","pdp-price"};
		// call browser driver
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		List<WebElement> Belt_count= driver.findElements(By.xpath("//div[@class='product-productMetaInfo']"));
		String basWin= driver.getWindowHandle();
		Actions builder = new Actions(driver);		
		int total=Belt_count.size();
		System.out.println("Total count: "+total);
		System.out.println(driver.getTitle());
		Row newRow = sht.createRow(0);
		newRow.createCell(0).setCellValue("Name");
		newRow.createCell(1).setCellValue("Price");
		for(int i=1; i<11;i++)
		{
			String forClick = "(//*[@class=\"img-responsive\"])[";   
			String click = forClick +i+"]";
			builder.moveToElement(driver.findElement(By.xpath(click))).click().build().perform();
			for(String handle : driver.getWindowHandles()) 
			{
				if(!handle.equals(basWin)) 
				{
					driver.switchTo().window(handle);
					Row newRow1 = sht.createRow(i);
					for(int j = 0;j<pageXpath.length;j++) 
					 {
						Cell cell = newRow1.createCell(j);
						String forPass = "//*[@class = '"+pageXpath[j]+"']"; 
						try {
							cell.setCellValue(driver.findElement(By.xpath(forPass)).getText().toString());
						}
						catch(NoSuchElementException e) {
							cell.setCellValue("Nil");
						}
					 }
				}
			}
			driver.close();
			driver.switchTo().window(basWin);
			//if(i==20) break;
		}
		
		FileOutputStream out = new FileOutputStream(new File("D:\\Testing\\WriteExcel\\Myntra.xlsx"));
		work.write(out);
		out.close();
		driver.quit();
		System.out.println("Product details are written successfully");
	
	}
		
	
	   
	

}
