package stepDefinitions;

import java.util.List;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import utilities.ContextUI;
import utilities.LoggerClass;
import utilities.UtilString;

public class LoginStep{
	
	private  ContextUI contextUI;
	private LoginPage login;
	public LoginStep(ContextUI context)
	{
		System.out.println("******LoginStep*******");
		this.contextUI = context;
		login = contextUI.getPageObjectManager().getLoginPage();
	}
	
	
	public void logout()
	{
		if(login.isInProgramPage(UtilString.PROGRAM_HEADER))
			login.logout();
		
		LoggerClass.info("driver close");
		contextUI.getDriver().quit();
	}
	
	//tag1
	@Given("user is on Browser")
	public void user_is_on_browser() {
	    LoggerClass.info("Is on browser");
	}
	
	@When("user opens the LMS website")
	public void user_opens_the_lms_website() {
		LoggerClass.info("Is on the lms Website");
	}
	
	@Then("user should be navigated to login page")
	public void userIsInLoginPage() {
		 LoggerClass.info("User is in the login page"); 
		if(login.isInLoginPage(UtilString.LOGIN_HEADER))
			Assert.assertTrue(true);
		else
			Assert.assertFalse(false);
	     
	}
	
	//tag2
	@Given("Any role is on Login Page")
	public void Admin_User_Staff_is_on_login_page()
	{
		userIsInLoginPage();
	}

	@When("Any role clicks login button after entering valid credentials {string} {string} {string} {string}")
	public void Admin_User_Staff_clicks_login_button_after_entering_valid_credentials(String Username, String Password, String Role, String code) 
	{
		if(Role.equals("User"))
			login.loginAsUser(Username, Password);
		else
			login.loginAsAdminStaff(Username, Password, Role, code);
		
		LoggerClass.info(Role+" Clicks login button");
	}

	@Then("Any role see header text as {string}")
	public void Admin_User_Staff_see_header_text_as(String programHeader) {
		Assert.assertEquals(programHeader, login.getProgramHeader());
		LoggerClass.info("User sees login header");
	}

	
	//tag3
	
	@When("Any role clicks login button after entering invalid credentials {string} {string} {string} {string}")
	public void Admin_User_Staff_clicks_login_button_after_entering_invalid_credentials(String Username, String Password, String Role, String code) {
		if(Role.equals("User"))
			login.loginAsUser(Username, Password);
		else
			login.loginAsAdminStaff(Username, Password, Role, code);
		
		LoggerClass.info(Role+" Clicks login button");
	}

	@Then("Any role should see a error message {string}")
	public void Admin_User_Staff_should_see_a_error_message(String ExpErrorMsg) {
		LoggerClass.info(" Verifying Error Message ");
		Assert.assertTrue(login.verifyErrorMsg(ExpErrorMsg));
	   
	}
	
	//tag4
	
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		userIsInLoginPage();
	}
	
	@When("user clicks Forgot password link")
	public void user_clicks_forgot_password_link() {
		LoggerClass.info("User clicks forget password Link");
	    login.verifyForgetPassword();
	}

	
	
	@Then("User Should see Enter Email text box")
	public void user_should_see_enter_email_text_box() 
	{
		LoggerClass.info("User Should see Enter Email text box");
		login.isEmailTextBoxDisplayed();
	}

	//tag5
	@Given("user is on Login Page and sees Enter Email text box")
	public void user_is_on_login_page_and_sees_enter_email_text_box() {
		LoggerClass.info("User sees Enter Email text box");
		userIsInLoginPage();
		login.isEmailTextBoxDisplayed();
	}

	@When("user  clicks continue after entering valid email address")
	public void user_clicks_continue_after_entering_valid_email_address() {
		LoggerClass.info("User enters valid email");
	    login.enterEmail(UtilString.VALID_EMAIL);
	}

	@Then("user should be redirected to enter verification code page and verification code will be sent to email")
	public void user_should_be_redirected_to_enter_verification_code_page_and_verification_code_will_be_sent_to_email() {
	   if(login.isInVerificationCodePage(UtilString.VERIFICATION_CODE_PAGE))
			Assert.assertTrue(true);
		else
			Assert.assertFalse(false);
	   
	}
	
	//tag6
	
	@Given("user is on Enter verification code Page")
	public void user_is_on_enter_verification_code_page() {
		 	login.isInVerificationCodePage(UtilString.VERIFICATION_CODE_PAGE);
			LoggerClass.info("User is in verification code page");
		
	}

	@When("user  clicks continue after entering verification code")
	public void user_clicks_continue_after_entering_verification_code() {
		login.enterVerificationCode(UtilString.CODE1, UtilString.CODE2, UtilString.CODE3, UtilString.CODE4, UtilString.CODE5);
		LoggerClass.info("User entered verfication codes");
	}

	@Then("user should be redirected reset password page")
	public void user_should_be_redirected_reset_password_page() {
		if(login.isInResetPassPage(UtilString.RESETPASS_HEADER))
		{
			LoggerClass.info("User in reset password page");
			Assert.assertTrue(true);
		}
		else
		{
			LoggerClass.info("User is not in reset password page");
			Assert.assertFalse(false);
		}
	}

	//tag7
	
	@When("user clicks Click here link to resend")
	public void user_clicks_click_here_link_to_resend() 
	{
		LoggerClass.info("Verifying ResendLink in Verification page");
		login.verifyResendLink();
	}

	@Then("The verification code should be resend to email")
	public void the_verification_code_should_be_resend_to_email() {
		LoggerClass.info("Verification is sent to the email");
	}
	
	//tag8
	@Given("user is on Reset Password Page")
	public void user_is_on_reset_password_page() {
	   login.isInResetPassPage(UtilString.RESETPASS_HEADER);
	   LoggerClass.info("User in reset password page");
	   
	}

	@When("user clicks submit button after entering new password and retype password")
	public void user_clicks_submit_button_after_entering_new_password_and_retype_password() {
		login.submitResetButton();
	}

	@Then("user  should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {
		userIsInLoginPage();
	}
	
	//tag9
	@When("user  clicks submit button after entering new password {string} and retype password {string}")
	public void user_clicks_submit_button_after_entering_new_password_and_retype_password(String string, String string2) {
		LoggerClass.info("Verifying invalid reset passwords");
		login.submitResetButton();
		
	}

	@Then("user  should see an error message {string}")
	public void user_should_see_an_error_message(String expErrMsg) {
	    LoggerClass.info("Error Message :"+expErrMsg);
	    Assert.assertTrue(login.verifyErrorMsg(expErrMsg));
	}

	@When("user clicks cancel button after entering new password and retype password")
	public void user_clicks_cancel_button_after_entering_new_password_and_retype_password() {
		LoggerClass.info("user clicks cancel button in Reset Password Page");
		login.cancelResetButton();
	}

	@Then("user  should see a refreshed reset password page with empty fields")
	public void user_should_see_a_refreshed_reset_password_page_with_empty_fields() {
	   if(login.isInResetPassPage(UtilString.RESETPASS_HEADER))
	   {
		   if(login.isInRefreshedResetPasswordPage())
		   {
			   LoggerClass.info("User in Refreshed resetpage");
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   LoggerClass.info("User not in Refreshed resetpage");
			   Assert.assertFalse(false);
		   }
	   }
	   else
	   {
		   LoggerClass.info("User not in Refreshed resetpage");
		   Assert.assertFalse(false); 
	   }
	}

	
}
