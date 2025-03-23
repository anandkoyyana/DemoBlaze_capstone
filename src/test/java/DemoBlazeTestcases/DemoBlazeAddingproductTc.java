package DemoBlazeTestcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DemoBlazePages.DemoHomePage;
import DemoBlazePages.DemoLoginPF;
import DemoBlazePages.DemoSignup;

public class DemoBlazeAddingproductTc extends Base {
	
	DemoHomePage dhp;
	DemoSignup dsp;
	DemoLoginPF dlpf;
	WebDriverWait wait;
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
	
	
	@Test 
	public void Adding_product_TC() 
	{
		dhp=new DemoHomePage(driver);
		
		//creating the test with respective test case
		ext.extent_createtest("DemoBlaze Adding product to cart page");
		
		dhp.phones().click();
		
		//click on phones linktext on home page
		ext.info("clicked on phones link text");
		
		//scroll vertically by 200 pixels
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		ext.info("Product is selected");
		//click on product linktext on home page
		dhp.product().click();
		
		//click on addto cart
		dhp.addtocart().click();
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dhp.cart()));
		
		ext.info("Product is added to cart");
		//wait unil alert is present
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		ext.pass_or_fail(text, "Product added", "Adding product to cart");
		
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
