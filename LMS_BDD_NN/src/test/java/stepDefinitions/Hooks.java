package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPage;
import utilities.ContextUI;
import utilities.LoggerClass;
import utilities.UtilString;

public class Hooks {
	public ContextUI contextUI;
	public LoginPage login;
	
	public Hooks(ContextUI context)
	{
		System.out.println("**********CommonStep*********");
		this.contextUI = context;
		login = contextUI.getPageObjectManager().getLoginPage();
	}
	
	@Before("not @login and not @Admin")
	public void loginAsUserBefore()
	{
		LoggerClass.info("**********loginAsUserBefore*********");
		String username = contextUI.getReadConfig().getUsername();
		String password = contextUI.getReadConfig().getPassword();
		login.loginAsUser(username, password);
	}
	
	@Before("@Admin")
	public void loginAsAdminBefore()
	{
		LoggerClass.info("**********loginAsAdminBefore*********");
		login.loginAsAdminStaff(UtilString.ADMIN_USERNAME, UtilString.ADMIN_PASSWORD, "Admin", UtilString.ADMIN_CODE);;
	}
	
	@Before(order=1)
	public void log(Scenario scenario) {
		LoggerClass.info("Scenario :"+ scenario.getName());
	}
	
	public void logout()
	{
		if(login.isInProgramPage(UtilString.PROGRAM_HEADER))
			login.logout();
	}
	
	//@After
	public void driverQuit() {
		LoggerClass.info("driver quit");
		contextUI.getDriver().quit();
	}
}
