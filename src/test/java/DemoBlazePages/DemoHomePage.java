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
	By home=By.xpath("(//a[@class='nav-link'])[1]");
	By cart=By.linkText("Cart");
	By phones=By.linkText("Phones");
	By phone=By.linkText("Samsung galaxy s6");
	By laptops=By.linkText("Laptops");
	By laptop=By.linkText("Sony vaio i5");
	By addtocart=By.xpath("//a[@class='btn btn-success btn-lg']");
	By nameof_user=By.id("nameofuser");
	By logout=By.id("logout2");
	
	public WebElement signup()
	{
		return driver.findElement(signup);
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
	
	public WebElement logout()
	{
		return driver.findElement(logout);
	}
	
	public WebElement home() 
	{
		return driver.findElement(home);
	}
	public WebElement cart()
	{
		return driver.findElement(cart);
	}
	
	public WebElement phones()
	{
		return driver.findElement(phones);
	}
	
	public WebElement phone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement addtocart()
	{
		return driver.findElement(addtocart);
	}
	
	public WebElement laptops()
	{
		return driver.findElement(laptops);
	}
	public WebElement laptop()
	{
		return driver.findElement(laptop);
	}
	
	public WebElement nameof_user()
	{
		return driver.findElement(nameof_user);
	}
	
}
