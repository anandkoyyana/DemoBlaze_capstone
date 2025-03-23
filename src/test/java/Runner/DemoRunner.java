package Runner;
//This class is for running Junit way



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	features="./src/test/java/Feature/Demo.feature",
	glue={"stepDef","hooks"}, plugin= {"pretty"},tags="@login", monochrome=false)

public class DemoRunner {

	
}
