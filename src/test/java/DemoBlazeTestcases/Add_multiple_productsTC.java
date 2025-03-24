package DemoBlazeTestcases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DemoBlazePages.DemoHomePage;

public class Add_multiple_productsTC extends Base{
	
	DemoHomePage dhp;
	
	Wait<WebDriver> wait;
	Config_reader cfr;
	Extent_report ext;
	
	@Parameters({"browser"})
	@BeforeTest
	public void readdata_openbrowser(String browser) throws IOException
	{
		//Intializing the Config_reader constructor
		cfr=new Config_reader();
		
		ext=new Extent_report();
		//invoking the browser from base class
		openbrowser(browser);
		
		ext.extent_createtest("DemoBlaze Home page");
		//navigate to the url page
		driver.navigate().to(cfr.url);
		
		ext.pass_or_fail(driver.getTitle(), "STORE", "Navigated to the specified URL");
			 
	}
	
	@Test (priority=0)
	public void Adding_1stproduct_TC() 
	{
		dhp=new DemoHomePage(driver);
		
		//creating the test with respective test case
		ext.extent_createtest("Adding 1st product to cart page");
		
		dhp.phones().click();
		
		//click on phones linktext on home page
		ext.info("clicked on phones link text");
		
		//scroll vertically by 200 pixels
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		ext.info("Phone is selected");
		//click on product linktext on home page
		dhp.phone().click();
		
		//click on addto cart
		dhp.addtocart().click();
		 wait = new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(40))
               .pollingEvery(Duration.ofSeconds(3))
               .ignoring(TimeoutException.class);

		
		wait.until(ExpectedConditions.elementToBeClickable(dhp.cart()));
		
		ext.info("Phone is added to cart");
		//wait unil alert is present
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		ext.pass_or_fail(text, "Product added", "Adding 1st product to cart");
		
	    dhp.home().click();
	    
	    
	}
	
	@Test (priority=1)
	public void Adding_2nd_productTc() 
	{
		dhp=new DemoHomePage(driver);
		
		//creating the test with respective test case
		ext.extent_createtest("Adding 2nd product to cart page");
		
		dhp.laptops().click();
		
		//click on phones linktext on home page
		ext.info("clicked on laptops link text");
		
		//scroll vertically by 200 pixels
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		
		wait.until(ExpectedConditions.visibilityOf(dhp.laptop()));
		//click on product linktext on home page
		dhp.laptop().click();
		
		ext.info("laptop is selected");
		//click on addto cart
		dhp.addtocart().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dhp.cart()));
		
		ext.info("Product is added to cart");
		//wait unil alert is present
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		ext.pass_or_fail(text, "Product added", "Adding 2nd product to cart");
		
	    driver.navigate().back();
	    
	    dhp.cart().click();
	    
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException
	{
		//calling close browser from base claSS
		closebrowser();
		ext.flush();
	}

}
