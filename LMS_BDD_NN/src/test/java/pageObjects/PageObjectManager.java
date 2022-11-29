package pageObjects;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.ProgramPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private  LoginPage loginPage;
	private  ProgramPage programPage;
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage getLoginPage()
	{
		if(loginPage==null)
		{
			System.out.println("***getLoginPage : login is null creating new");
			loginPage = new LoginPage(driver);
		}
		else {
			System.out.println("***getLoginPage : login is not null");
		}
		return loginPage;
	}
	
	public ProgramPage getProgramPage()
	{
		if(programPage==null)
		{
			programPage = new ProgramPage(driver);
		}
		return programPage;
	}

}
