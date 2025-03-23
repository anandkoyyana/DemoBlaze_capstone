package DemoBlazeTestcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public static WebDriver driver=null;
	public static void openbrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else
		{
			System.out.println("Browser is MisMatched");
		}
			
	}
	
	public static void closebrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
