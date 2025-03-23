package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoLoginPF {
       
	WebDriver driver;
	public DemoLoginPF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginusername") WebElement username;
	@FindBy(id="loginpassword") WebElement password;
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]") WebElement loginbtn;	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[3]") WebElement closebtn;
	
	public WebElement username()
	{
		return username;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement loginbtn()
	{
		return loginbtn;
	}
	
	public WebElement closebtn()
	{
		return closebtn;
	}
}
