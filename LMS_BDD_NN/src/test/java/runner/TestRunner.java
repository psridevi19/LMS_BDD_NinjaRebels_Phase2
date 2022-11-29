package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber.html",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, // reporting purpose
		monochrome = true, // console output
		dryRun = false,
	 //tags = "@Batch", //tags from feature file
		//publish = true, 
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