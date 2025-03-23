package DemoBlazePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoSignup {
	
	WebDriver driver;
	public DemoSignup(WebDriver driver) {
		this.driver=driver;	
	}
	
	public By username=By.id("sign-username");
	By password=By.id("sign-password");
	By signupbtn=By.xpath("(//button[@class='btn btn-primary'])[2]");
	By closebtn=By.xpath("(//button[@class='btn btn-secondary'])[2]");
	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement signupbtn()
	{
		return driver.findElement(signupbtn);
	}
	
	public WebElement closebtn()
	{
		return driver.findElement(closebtn);
	}
	
	
	

}
