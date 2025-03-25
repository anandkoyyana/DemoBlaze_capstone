package DemoBlazeTestcases;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DemoBlazePages.DemoHomePage;
import DemoBlazePages.DemoLoginPF;
import DemoBlazePages.DemoSignup;

public class LoginTc extends Base{
	
	DemoHomePage dhp;
	DemoSignup dsp;
	DemoLoginPF dlpf;
	WebDriverWait wait;
	Config_reader cfr;
	Extent_report ext;
	
	@Parameters("browser")
	@BeforeTest
	public void readdata_openbrowser(String browser) throws IOException
	{
		//Intializing the Config_reader constructor
		cfr=new Config_reader();
		//intializing the Extent report constructor
		ext=new Extent_report();
		//invoking the browser from base class
		openbrowser(browser);
		//creating test in extent report
		ext.extent_createtest("DemoBlaze Home page");
		//navigate to the url page
		driver.navigate().to(cfr.url);
		//verify the navigated to the specified url
		ext.pass_or_fail(driver.getTitle(), "STORE", "Navigated to the specified URL");
			 
	}
	
	
	@Test (priority=0)
	public void Login_TC_for_invaliddata()
	{
		//calling the constructor of DemoHomePage
		dhp=new DemoHomePage(driver);
		//creating the test with respective test case
		ext.extent_createtest("DemoBlaze login page for Invalid data");
		//click on login linktext on home page
		dhp.login().click();
		//calling constructor 
	    dlpf=new DemoLoginPF(driver);
	    
	   //sending username and password to the textboxes
	    dlpf.username().sendKeys(cfr.username);
	    wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.textToBePresentInElementValue(dlpf.username(),cfr.username));
	    
	    ext.info("username is Entered");
	    
	    ext.info("password as blank");
	    dlpf.loginbtn().click();
	    
	    ext.info("clicked on login button");
	    
	  //wait until alert is present
	  	wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	  	wait.until(ExpectedConditions.alertIsPresent());
	 	Alert alert=driver.switchTo().alert();
	 	String text=alert.getText();
	  	alert.accept();
	   
	  	wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	  	wait.until(ExpectedConditions.elementToBeClickable(dlpf.closebtn()));
	    dlpf.closebtn().click();
	    //verify the both expected and actual text
	    ext.pass_or_fail(text, "Please fill out Username and Password.", "Login with invalid data");
	    
	}
	
	@Test (priority=1)
	public void Login_TC_for_validdata()
	{
		//calling the constructor of DemoHomePage
		dhp=new DemoHomePage(driver);
		//creating the test with respective test case
		ext.extent_createtest("DemoBlaze login page valid data");
		//click on login linktext on home page
		dhp.login().click();
		//calling constructor 
	    dlpf=new DemoLoginPF(driver);
	    
	   //sending username and password to the textboxes
	    dlpf.username().clear();
	    dlpf.username().sendKeys(cfr.username);
	    wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.textToBePresentInElementValue(dlpf.username(),cfr.username));
	    
	    ext.info("username is Entered");
	    
	    dlpf.password().sendKeys(cfr.password);
	    //wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.textToBePresentInElementValue(dlpf.password(),cfr.password));
	   
	    ext.info("password is Entered");
	    dlpf.loginbtn().click();
	    
	    ext.info("clicked on login button");
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
 	    String text=dhp.nameof_user().getText();
 	    //verify the both expected and actual text
 	    ext.pass_or_fail(text, "Welcome "+cfr.username, "Login with valid data");
    
	}
	
	
	@AfterTest
	public void close_browser() throws InterruptedException
	{
		//calling close browser from base claSS
		closebrowser();
		ext.flush();
	}
	


}
