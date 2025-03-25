package DemoBlazePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoCartPF {

	  WebDriver driver;
	  public DemoCartPF(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
	  }
	  
	  @FindBy(id="name") WebElement name;
	  @FindBy(id="country") WebElement country;
	  @FindBy(id="city") WebElement city;
	  @FindBy(id="card") WebElement card;
	  @FindBy(id="month") WebElement month;
	  @FindBy(id="year") WebElement year;
	  @FindBy(xpath="//button[@class='btn btn-success']") WebElement place_order_btn;
	  @FindBy(xpath="(//button[@class='btn btn-secondary'])[3]") WebElement close_btn;
	  @FindBy(xpath="(//button[@class='btn btn-primary'])[3]") WebElement purchase_btn;
	  @FindBy(xpath="//div[@class='sa-icon sa-custom']/following-sibling::h2") WebElement success_text;
	  @FindBy(css="button[class='confirm btn btn-lg btn-primary']") WebElement ok_btn;
	  
	  public WebElement name()
	  {
		  return name;
	  }
	  
	  public WebElement country()
	  {
		  return country;
	  }
	  
	  public WebElement city()
	  {
		  return city;
	  }
	  
	  public WebElement card()
	  {
		  return card;
	  }
	  
	  public WebElement month()
	  {
		  return month;
	  }
	  
	  public WebElement year()
	  {
		  return year;
	  }
	  
	  public WebElement place_order_btn()
	  {
		  return place_order_btn;
	  }
	  
	  public WebElement purchase_btn()
	  {
		  return purchase_btn;
	  }
	  
	  public WebElement close_btn()
	  {
		  return close_btn;
	  }
	  
	  public WebElement success_text()
	  {
		  return success_text;
	  }
	  
	  public WebElement ok_btn()
	  {
		  return ok_btn;
	  }
	    
}
