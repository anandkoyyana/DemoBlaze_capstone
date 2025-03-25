package DemoBlazeTestcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DemoBlazePages.DemoHomePage;
import DemoBlazePages.DemoLoginPF;

public class LogoutTC extends Base{
	
	DemoHomePage dhp;
	Config_reader cfr;
	DemoLoginPF dlpf;
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
	
	@Test 
	public void Logout_Tc() 
	{
        dhp=new DemoHomePage(driver);
		
        wait = new FluentWait<>(driver)
	               .withTimeout(Duration.ofSeconds(30))
	               .pollingEvery(Duration.ofSeconds(3))
	               .ignoring(TimeoutException.class);
        //click on login link on home page
		dhp.login().click();
		
		//calling constructor 
	    dlpf=new DemoLoginPF(driver);
		//sending username and password to the textboxes
	    dlpf.username().sendKeys(cfr.username);
	    dlpf.password().sendKeys(cfr.password);
		
	    //wait unil password text present in password textbox.
	  	wait.until(ExpectedConditions.textToBePresentInElementValue(dlpf.password(),cfr.password));
		//click on addto cart
	  	dlpf.loginbtn().click();
	  	
		try
		{
			//wait unil welcome msg is present
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
			String text=dhp.nameof_user().getText();
			assertEquals("Welcome "+cfr.username, text);
		}
		catch(Exception e)
		{
			System.out.println("login Failed");
		}
		
		dhp.logout().click();
		 
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException
	{
		//calling close browser from base claSS
		closebrowser();
	}

}
