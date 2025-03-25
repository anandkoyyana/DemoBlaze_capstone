package DemoBlazeTestcases;

import static org.testng.Assert.assertEquals;

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

import DemoBlazePages.DemoCartPF;
import DemoBlazePages.DemoHomePage;

public class Checkout_productTC extends Base{
	
    DemoHomePage dhp;
	Config_reader cfr;
	DemoCartPF dcpf;
	Wait<WebDriver> wait;
	
	@Parameters({"browser"})
	@BeforeTest
	public void readdata_openbrowser(String browser) throws IOException
	{
		//Intializing the Config_reader constructor
		cfr=new Config_reader();
		
		//invoking the browser from base class
		openbrowser(browser);
		
		//navigate to the url page
		driver.navigate().to(cfr.url);
	
			 
	}
	
	@Test (priority=0)
	public void Adding_product_to_cart() 
	{
        dhp=new DemoHomePage(driver);
		
        wait = new FluentWait<>(driver)
	               .withTimeout(Duration.ofSeconds(40))
	               .pollingEvery(Duration.ofSeconds(3))
	               .ignoring(TimeoutException.class);
        //click on phones linktext on home page
		dhp.phones().click();
		
		//scroll vertically by 200 pixels
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		//click on product linktext on home page
		dhp.phone().click();
		
		//click on addto cart
		dhp.addtocart().click();
			
		//wait unil alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		try
		{
			assertEquals("Product added", text);
		}
		catch(Exception e)
		{
			System.out.println("TestCase Failed");
		}
		
	   
	}
	
	@Test (priority=1)
	public void Checkout_product_with_invalid() 
	{
        dhp=new DemoHomePage(driver);
		
        dhp.cart().click();
        dcpf=new DemoCartPF(driver);
        
        //click on place order buton on home page
		dcpf.place_order_btn().click();
		
		//wait unil alert is present
		//wait.until(ExpectedConditions.visibilityOf(dcpf.name()));
		
		//filling all the required fields Except credit card field(blank)
		dcpf.name().sendKeys(cfr.username);
		dcpf.country().sendKeys("India");
		dcpf.city().sendKeys("Srikakulam");
		
		//scroll vertically by 200 pixels
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		dcpf.month().sendKeys("June");
		dcpf.year().sendKeys("2025");
		
		//click on purchase button
		dcpf.purchase_btn().click();
			
		//wait unil alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		try
		{
			assertEquals("Please fill out Name and Creditcard.", text);
		}
		catch(Exception e)
		{
			System.out.println("TestCase Failed");
		}
		
	    
	}
    
	@Test (priority=2)
	public void Checkout_product_with_valid() 
	{ 
		//clear all the fields
		dcpf.name().clear();
		dcpf.country().clear();
		dcpf.card().clear();
		dcpf.city().clear();
		dcpf.month().clear();
		dcpf.year().clear();
		//filling all the required fields 
		dcpf.name().sendKeys(cfr.username);
		dcpf.country().sendKeys("India");
		dcpf.card().sendKeys("123456789023");
		//scroll vertically by 200 pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		
		dcpf.city().sendKeys("Srikakulam");
		dcpf.month().sendKeys("June");
		dcpf.year().sendKeys("2025");
		
		//click on purchase button
		dcpf.purchase_btn().click();
			
		//wait unil success msg is present
		wait.until(ExpectedConditions.visibilityOf(dcpf.success_text()));
		String text=dcpf.success_text().getText();
		
		try
		{
			assertEquals("Thank you for your purchase!", text);
		}
		catch(Exception e)
		{
			System.out.println("TestCase Failed");
		}
		
		dcpf.ok_btn().click();
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException
	{
		//calling close browser from base claSS
		closebrowser();
	}

}
