package Runner;

//This class is for running TestNG way
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	features="./src/test/java/Feature/Demo.feature",
	glue={"stepDef,hooks"}, plugin= {"pretty"}, tags="@login",monochrome=true)

public class DemoTestNGRunner extends AbstractTestNGCucumberTests {

}
