package DemoBlazePages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoHomePage {

	WebDriver driver;
	public DemoHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signup=By.id("signin2");
	By login=By.id("login2");
	By cart=By.linkText("Cart");
	By phones=By.linkText("Phones");
	By product=By.linkText("Samsung galaxy s6");
	By addtocart=By.xpath("//a[@class='btn btn-success btn-lg']");

	public WebElement signup()
	{
		return driver.findElement(signup);
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
	
	public WebElement cart()
	{
		return driver.findElement(cart);
	}
	
	public WebElement phones()
	{
		return driver.findElement(phones);
	}
	
	public WebElement product()
	{
		return driver.findElement(product);
	}
	
	public WebElement addtocart()
	{
		return driver.findElement(addtocart);
	}
	

	
}
