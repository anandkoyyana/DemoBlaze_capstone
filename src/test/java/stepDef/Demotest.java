package stepDef;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import DemoBlazePages.DemoHomePage;
import DemoBlazePages.DemoLoginPF;
import DemoBlazeTestcases.Base;
import DemoBlazeTestcases.Extent_report;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demotest {
	
	DemoHomePage dhp;
	DemoLoginPF dlpf;
    WebDriver driver=Base.driver;
    Extent_report ext;
     
	@Given("open the Browser")
	public void open_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		ext=new Extent_report();
		ext.extent_createtest("DemoBlaze Home page");
	    
	    ext.pass_or_fail(driver.getTitle(), "STORE", "Navigated to the specfied url");
	}
	
	@Then("user is on DemoBlaze page")
	public void user_is_on_demo_blaze_page() {
	    // Write code here that turns the phrase above into concrete actions
		ext.extent_createtest("user on DemoBlaze Page");
	    System.out.println("user on DemoBlaze Page");
	    
	}

	@When("User enters username and password as {string} and {string}")
	public void user_enters_username_as_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		 dhp=new DemoHomePage(driver);
		    dhp.login().click();
		    dlpf=new DemoLoginPF(driver);
		    dlpf.username().sendKeys(string);
		    ext.info("username is Entered");
		    dlpf.password().sendKeys(string2);
		    ext.info("password is Entered");
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		dlpf.loginbtn().click();
		ext.info("clicked on login button");
		
		try
		{
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			alert.accept();
			ext.pass_or_fail(text, "Please fill out Username and Password.", "login for invalid data");
		}
		catch (Exception e)
		{
			ext.pass_or_fail("Noalert", "Noalert", "login for validdata");
		}
	}
    
	@Then("Close The browser")
	public void close_the_browser() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Close The browser");
	    ext.flush();
	}
}
