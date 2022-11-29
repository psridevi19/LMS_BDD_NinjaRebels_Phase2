package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true, // console output
		dryRun = false,
		features = { "Features" }, // location of feature files
		glue = "classpath:stepDefinitions") // location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests {

	/*
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	@AfterSuite
	public void shutdown() {
		//DriverProvider.quit();
	}
	*/
}