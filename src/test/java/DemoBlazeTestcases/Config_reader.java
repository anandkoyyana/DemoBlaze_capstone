package DemoBlazeTestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config_reader {
     
	public String browser,url,username,password;
	public Config_reader() throws IOException
	{
		//connecting to the data.properties file
		FileInputStream fis=new FileInputStream("./src/test/java/data/data.properties");
		Properties prop=new Properties();
		prop.load(fis);
				
		//loading the required data from the file 
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
	}
	
}
