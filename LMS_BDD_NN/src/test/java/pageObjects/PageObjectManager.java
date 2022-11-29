package pageObjects;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {
	
	private WebDriver driver;
	private  LoginPage loginPage;
	private  ProgramPage programPage;
	private AssignmentPage assignmentPage;
	private RegisterPage registerPage;
	private Attendancepage attendancePage;
	private Batchpage batchPage;
	private ManageUserPage manageUserPage;
	
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

	public AssignmentPage getAssignmentPage()
	{
		if(assignmentPage==null)
		{
			assignmentPage = new AssignmentPage(driver);
		}
		return assignmentPage;
	}
	
	public RegisterPage getRegisterPage()
	{
		if(registerPage==null)
		{
			registerPage = new RegisterPage(driver);
		}
		return registerPage;
	}
	
	public Attendancepage getAttendancePage()
	{
		if(attendancePage==null)
		{
			attendancePage = new Attendancepage(driver);
		}
		return attendancePage;
	}
	
	public Batchpage getBatchPage()
	{
		if(batchPage==null)
		{
			batchPage = new Batchpage(driver);
		}
		return batchPage;
	}
	
	public ManageUserPage getManageUserPage()
	{
		if(manageUserPage==null)
		{
			manageUserPage = new ManageUserPage(driver);
		}
		return manageUserPage;
	}
}
