package DemoBlazeTestcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DemoBlazePages.DemoHomePage;
import DemoBlazePages.DemoLoginPF;


public class AddingproductTc extends Base {
	
	DemoHomePage dhp;
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
		//intializing the Extent report constructor
		ext=new Extent_report();
		//invoking the browser from base class
		openbrowser(browser);
		
		ext.extent_createtest("DemoBlaze Home page");
		//navigate to the url page
		driver.navigate().to(cfr.url);
		
		ext.pass_or_fail(driver.getTitle(), "STORE", "Navigated to the specified URL");
		// creating the test with respective test case
		ext.extent_createtest("DemoBlaze login page ");
		dhp=new DemoHomePage(driver);
		// click on login linktext on home page
		dhp.login().click();
		// calling constructor
		dlpf = new DemoLoginPF(driver);

		// sending username and password to the textboxes
		dlpf.username().clear();
		dlpf.username().sendKeys(cfr.username);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(dlpf.username(), cfr.username));

		ext.info("username is Entered");

		dlpf.password().sendKeys(cfr.password);
		// wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(dlpf.password(), cfr.password));

		ext.info("password is Entered");
		dlpf.loginbtn().click();

		ext.info("clicked on login button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		String text = dhp.nameof_user().getText();
		// verify the both expected and actual text
		ext.pass_or_fail(text, "Welcome " + cfr.username, "Login");	    
			 
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
		
		ext.info("Phone is selected");
		//click on product linktext on home page
		dhp.phone().click();
		
		//click on addto cart
		dhp.addtocart().click();
		
		ext.info("Product is added to cart");
		//wait unil alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		ext.pass_or_fail(text, "Product added.", "Adding product to cart");
		
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
