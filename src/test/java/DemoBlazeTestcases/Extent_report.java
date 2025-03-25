package DemoBlazeTestcases;

import static org.testng.Assert.assertEquals;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_report {

	//required extent reports variables declared
	public static ExtentReports extent;
	public static ExtentTest test;
	private static ExtentSparkReporter spark;
	
	public Extent_report()
	{
		//providing extent report path 
		spark = new ExtentSparkReporter("./target/ExtentReport"+System.currentTimeMillis()+".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	public void extent_createtest(String string)
	{
		//creating the test with respective test case
		test = extent.createTest(string);
	}
	
	public void info(String msg)
	{
		test.log(Status.INFO, msg);
	}
	public void pass_or_fail(String actual, String Expect, String msg)
	{
		try
		{
			//In extent report, pass or fail will shown based on the condition 
			assertEquals(actual,Expect);
			test.log(Status.PASS, msg+" is passed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, msg+" is Failed");
			e.printStackTrace();
		}
	}
	
	public void flush()
	{
		extent.flush();
	}
	
}
