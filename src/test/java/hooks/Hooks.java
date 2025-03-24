package hooks;

import java.io.IOException;


import DemoBlazeTestcases.Base;
import DemoBlazeTestcases.Config_reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {
	
	@Before
	public void open_the_browser() throws IOException {
	   
		Config_reader cfg=new Config_reader();
		openbrowser(cfg.browser);
		driver.navigate().to(cfg.url);

	}
	@After
	public void close_the_browser() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		closebrowser();
	    
	}
}
