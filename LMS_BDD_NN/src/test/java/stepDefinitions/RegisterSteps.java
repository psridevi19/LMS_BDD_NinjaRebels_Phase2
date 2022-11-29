package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPage;
import utilities.ContextUI;
import utilities.LoggerClass;


public class RegisterSteps {
    private ContextUI contextUI;
	private RegisterPage register;
	private WebDriver driver;
	
	public RegisterSteps(ContextUI context)
	{
		System.out.println("******RegisterSteps*******");
		this.contextUI = context;
		register = contextUI.getPageObjectManager().getRegisterPage();
		driver = contextUI.getDriver();
	}
	
	@Given("User is on LMS website")
	public void user_is_on_lms_website() {
		driver.get("");
		LoggerClass.info("User is on LMS Website");
		System.out.println("User is on LMS Website");
		
	   }

	@When("User lands on Registration page")
	public void user_lands_on_registration_page() {
		register.RegisterPageTitle();
	 System.out.println("User navigated to Registeration page");
	}

	@Then("User should see the heading on the form as {string}")
	public void user_should_see_the_heading_on_the_form_as(String string) {

		 String title=driver.getTitle();
		 System.out.println("Title is "+title);
		 String expected_title="Registration Form";
		 Assert.assertEquals(title, expected_title);
		 LoggerClass.info("Test passed");
		 System.out.println("Test passed");
		 
	}

	@Then("User should see a button with text {string} on the form")
	public void user_should_see_a_button_with_text_on_the_form(String string) {
		boolean isEnabled=driver.findElement(By.xpath("//input[@id='login']")).isEnabled();
		boolean isDisplayed=driver.findElement(By.xpath("//input[@id='login']")).isDisplayed();
		if(isEnabled) {
			System.out.println("loginbtn is enabled");
		}else {
			System.out.println("loginbtn is not Enabled");
		}
		if(isDisplayed) {
			System.out.println("loginbtn is displayed");
		}else {
			System.out.println("loginbtn is not displayed");
		}
	
	  
	}

	@Given("User is on the Registeration Page")
	public void user_is_on_the_registeration_page() {
		register.RegisterPageTitle();
		LoggerClass.info("User navigated to Registeration page");
		 System.out.println("User navigated to Registeration page");
	   
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		register.clickLogin();
	}

	@Then("User should be navigated to Login page")
	public void user_should_be_navigated_to_login_page() {
	System.out.println("User navigated to Login page");
		}

	@When("User clicks submit button with all fields empty")
	public void user_clicks_submit_button_with_all_fields_empty() throws InterruptedException {
		register.clickSignup();
		Thread.sleep(2000);
	  
	}

	@Then("User should get a message {string}")
	public void user_should_get_a_message(String string) {
		String actual_error=driver.findElement(By.xpath("//*[@id=errormsg")).getText();
		String expected_error="Please enter your all fields";
		Assert.assertEquals(actual_error, expected_error);
		//Assert.assertTrue(actual_error.contains("Please enter your all fields"));
		System.out.println("Test passed");
	   
	}
	@When("User clicks Signup button after enters {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} and  {string}")
	public void user_clicks_signup_button_after_enters_and(String fname, String lname, String addres, String streetName, String City, String State, String Zip, String birthDate, String phoneNumber, String userName, String passWord, String Email) {
	   register.firstname(fname);
	   register.lastname(lname);
	   register.enteraddress(addres);
	   register.enterstreet(streetName);
	   register.entercity(City);
	   register.enterstate(State);
	   register.enterbirthdate(Zip);
	   register.enterbirthdate(birthDate);
	   register.enterphonenum(phoneNumber);
	   register.enterusername(userName);
	   register.enterpassword(passWord);
	   register.enteremail(Email);
	   register.clickSignup();
	}

    @Then("Registeration should be successful")
	public void registeration_should_be_successful() {
    	String actual_msg=driver.findElement(By.xpath("//*[@id=registersuccessfulmsg")).getText();
		String expected_msg="Registered Successfully";
		Assert.assertEquals(actual_msg, expected_msg);
		//Assert.assertTrue(actual_msg.contains("Registered Successfully"));
		LoggerClass.info("Registration completed");
		System.out.println("Registration completed");
	   }

	@Then("User should see a error message")
	public void user_should_see_a_error_message(String getText) {
		register.warningText(getText);
		System.out.println("Test passed"+getText);
		}
}
