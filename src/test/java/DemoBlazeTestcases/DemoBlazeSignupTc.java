package DemoBlazeTestcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DemoBlazePages.DemoHomePage;
import DemoBlazePages.DemoLoginPF;
import DemoBlazePages.DemoSignup;

public class DemoBlazeSignupTc extends Base{
	
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
	
	@Test (priority=0)
	public void Signup_TC_for_Invalid()  

	{
		//calling the constructor of DemoHomePage
		dhp=new DemoHomePage(driver);
		
		//creating the test with respective test case
		ext.extent_createtest("DemoBlaze signup page for invalid");
		//click on signup linktext on home page
		dhp.signup().click();
		
		//calling constructor
		dsp=new DemoSignup(driver);
		
		//sending username and password to the textboxes
		dsp.username().sendKeys(cfr.username);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(dsp.username(), cfr.username));
		
		ext.info("username is Entered");
		
		ext.info("password leave as blank");
		
		dsp.signupbtn().click();
		ext.info("clicked on sign up button");
		//wait until alert is present
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		ext.pass_or_fail(text, "Please fill out Username and Password.", "Signup");
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	  	wait.until(ExpectedConditions.elementToBeClickable(dsp.closebtn()));
		dsp.closebtn().click();
		
	}
	
	@Test (priority=1)
	public void Signup_TC_for_validdata()  

	{
		//calling the constructor of DemoHomePage
		dhp=new DemoHomePage(driver);
		
		//creating the test with respective test case
		ext.extent_createtest("DemoBlaze signup page");
		//click on signup linktext on home page
		dhp.signup().click();
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	  	wait.until(ExpectedConditions.elementToBeClickable(dhp.signup()));
		
		
		//calling constructor
		dsp=new DemoSignup(driver);
		
		dsp.username().clear();
		//sending username and password to the textboxes
		dsp.username().sendKeys(cfr.username);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(dsp.username(), cfr.username));
		
		ext.info("username is Entered");
		
		dsp.password().sendKeys(cfr.password);
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(dsp.password(), cfr.password));
		
		ext.info("password is Entered");
		
		dsp.signupbtn().click();
		ext.info("clicked on sign up button");
		//wait until alert is present
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		
		ext.pass_or_fail(text, "This user already exist.", "Signup");
		
		dsp.closebtn().click();
		
	}

	
	@AfterTest
	public void close_browser() throws InterruptedException
	{
		//calling close browser from base claSS
		closebrowser();
		ext.flush();
	}
	

}
