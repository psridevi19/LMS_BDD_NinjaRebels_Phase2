package stepDefinitions;

import utilities.XLUtility;

import java.io.IOException;

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
	private String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\LMS.xlsx";
	private XLUtility xlutils = new XLUtility(path);
	
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
	public void loginAsAdminBefore() throws IOException
	{
		int rowCount = xlutils.getRowCount("Login");
		int columnCount = xlutils.getColumnCount("Login", 1);
		String code;
		String loginData[][] = new String[rowCount][columnCount];
		for (int i=1;i<=rowCount;i++)
		{
			for(int j=0; j<columnCount-1;j++)
			{
				loginData[i-1][j]= xlutils.getCellData("login",i,j);
			}
		}
		 code = xlutils.getCellData("login",1,2);
		
		LoggerClass.info("**********login As Admin *********");
		LoggerClass.info("Username :"+loginData[0][0]);
		//login.loginAsAdminStaff(UtilString.ADMIN_USERNAME, UtilString.ADMIN_PASSWORD, "Admin", UtilString.ADMIN_CODE);
		login.loginAsAdminStaff(loginData[0][0], loginData[0][1],"Admin", code);
	}
	
	@Before(order=1)
	public void log(Scenario scenario) {
		LoggerClass.info("Scenario :"+ scenario.getName());
	}
	
	@After
	public void logout()
	{
		if(login.isInProgramPage(UtilString.PROGRAM_HEADER))
			login.logout();
	}
	
	//@Afterall
	public void driverQuit() {
		LoggerClass.info("driver quit");
		contextUI.getDriver().quit();
	}
}
