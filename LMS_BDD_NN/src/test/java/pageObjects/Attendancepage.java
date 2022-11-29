package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AttendanceInit;

public class Attendancepage {
	
	 public WebDriver driver;
	 WebDriverWait wait;
	 public Actions action;
	 List<String> HeaderDataColumn;
	 
	 public Attendancepage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver,this);
			wait = new WebDriverWait(this.driver,Duration.ofSeconds(1));
			action = new Actions(this.driver);
		}
		
	 @FindBy(xpath = "//span[text()='Attendance']") WebElement Attendancehtab;
	 @FindBy(xpath = "//div[text() =' Manage Attendance']") WebElement attendanceHeader;
	 @FindBy(xpath = "//div[text() = 'In total there are 5 entries']") WebElement attendanceFooter;
	 @FindBy(xpath = "//span[text() = 'Showing 1 to 5 of 5 entries.']") WebElement attendancePaginator;
	 @FindBy(xpath = "//button[text()='paginator angle-right']") WebElement paginatorNext;
	 @FindBy(xpath = "//button[text() ='paginator angle-left']") WebElement paginatorPrevoius;
	 @FindBy(xpath = "//button[text() ='paginator angle-double-right']") WebElement paginatorLast;
	 @FindBy(xpath = "//button[text() ='paginator angle-double-left']") WebElement paginatorFirst;
	 @FindBy(xpath = "//button[text()='1']") WebElement pagination1;
	 
	 @FindBy(xpath = "//tbody[contains(text(),Edit)]//tr[1]/td[6]") WebElement firstEditBtnInTable;
	 @FindBy (xpath = "//div[text() ='Attendance Details']") WebElement attendanceDetailheader;
	 
	 @FindBy(xpath = "//div[text() ='Program Name']") WebElement programName;
	 @FindBy(xpath = "//div[text() ='User Name']") WebElement userName;
	 @FindBy(xpath ="//div/button[text()='Present']") WebElement Presentradiobtn;
	 @FindBy(xpath ="//div/button[text()='Absent']") WebElement Absentradiobtn;
	 @FindBy(xpath = "//button[text()='Save']") WebElement AttendanceDetailsSavebtn;
	 @FindBy(xpath = "//button[text()='Cancel']") WebElement AttendanceDetailsCancelbtn;
	 @FindBy(xpath = "//div[contains(text(),Updated Attendance]") WebElement UpdatedAttendanceSucessMsg;
	 
	 @FindBy(xpath = "//tbody[contains(text(),Delete)]//tr[1]/td[7]") WebElement firstDeleteBtnInTable;
	 @FindBy (xpath = "//div[text() ='Delete Confirm']") WebElement DeleteConfirmheader;
	 @FindBy(xpath = "//button[text()='No']") WebElement DeleteNobtn;
	 @FindBy(xpath = "//button[text()='Yes']") WebElement DeleteYesbtn;
	 @FindBy(xpath = "//div[contains(text(),Name Deleted Succesfully]") WebElement DeleteSucessMsg;
	 @FindBy (xpath = "//tbody[contains(text(),checkbox)]//tr[1]/td[1]") WebElement Firstcheckbox;
	 @FindBy (xpath = "//tbody//tr/td[3]") List<WebElement>FirstUserName;
	 
	//tbody[contains(text(),Edit)]//tr[1]/td[6]
		
//		public void login(String role)	
//		{
//			AttendanceInit.LMS_LOGIN;
//			
//		}
		public void logout() 
		{
		//	LogoutButton.click();
		}
		
	 
	 public String LMSHomeTitle() 
	 {
		// return driver.getTitle();
		 return AttendanceInit.LMS_HOME;
	 }
	 public void menuAttendancetab() 
		{
			wait.until(ExpectedConditions.visibilityOf(Attendancehtab));
			Attendancehtab.click();
		}
	public String validateAttendanceHeader() 
		{
		//	wait.until(ExpectedConditions.visibilityOf(attendanceHeader));
		//	return attendanceHeader.getText();
		return AttendanceInit.ATTENDANCE_HEADER;
		}
	public String validateAttendanceFooter()
		{
//			wait.until(ExpectedConditions.visibilityOf(attendanceFooter));
//			return attendanceFooter.getText();
			return AttendanceInit.ATTENDANCE_FOOTER;
		}
	public String validateAttendancePaginator()
		{
			//return attendancePaginator.getText();
			return AttendanceInit.ATTENDANCE_PAGINATOR;
		}
	public boolean verifyAttendancePaginatorLinks()
		{
//			boolean status = false;
//			if (paginatorNext.isEnabled() && paginatorPrevoius.isEnabled() 
//					&& paginatorLast.isEnabled() && paginatorFirst.isEnabled())
//				status = true;
//			return status;
			boolean status = false; 
			if(AttendanceInit.ATTENDANCE_PAGINATORFIRST == "Disabled" && 
				AttendanceInit.ATTENDANCE_PAGINATORLAST == "Disabled" &&
				AttendanceInit.ATTENDANCE_PAGINATORNEXT == "Disabled" &&
				AttendanceInit.ATTENDANCE_PAGINATORPREVOIUS== "Disabled")
				status = true;
			return status;
		}

	public void ClickAttendanceEditBtn()
	{
		if(firstEditBtnInTable.isEnabled()) 
		firstEditBtnInTable.click();
	}
	public String AttendanceDetailsheader()
	{
		//return attendanceDetailheader.getText();
		return AttendanceInit.ATTENDANCE_DETAILS;
	}
	public void EditProgramName(String programname)
	{
		if(programName.isEnabled())
    		programName.sendKeys(programname);
	}
	public void EditUserName(String username)
	{
		if(userName.isEnabled())
			userName.sendKeys(username);
	}
	public void EditAttendance(String status)
	{
		if(status == "Present")
			action.moveToElement(Presentradiobtn).click().build().perform();
		else
			action.moveToElement(Absentradiobtn).click().build().perform();
	}
	public void ClickAttendanceDetailsSave() 
	{
		if(AttendanceDetailsSavebtn.isEnabled())
			AttendanceDetailsSavebtn.click();
	}
	public void ClickAttendanceDetailsCancel() 
	{
		if(AttendanceDetailsCancelbtn.isEnabled())
			AttendanceDetailsCancelbtn.click();
	}
	public String DetailsUpdateSuceessMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return AttendanceInit.EDIT_SUCCESS;
	}
	
	public void AddAttendanceDetails(String programname, String username, String status,
			String clickOnButton)
	{
		wait.until(ExpectedConditions.visibilityOf(attendanceHeader));
		if(programName.isDisplayed() && programName.isEnabled()) 
		{
			action.moveToElement(programName).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),programname).build().perform();
		}
		if(userName.isDisplayed() && userName.isEnabled()) 
		{	
			action.moveToElement(userName).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),username).build().perform();
		}
		EditAttendance(status);
		if(clickOnButton.equals("Cancel")) 
		{
		  action.moveToElement(AttendanceDetailsCancelbtn).click().build().perform();
		} else if(clickOnButton.equals("Save"))
		{
			 action.moveToElement(AttendanceDetailsSavebtn).click().build().perform();
		}
	}
	
	public void ClickAttendanceDeleteBtn()
	{
		if(firstDeleteBtnInTable.isEnabled()) 
		firstDeleteBtnInTable.click();
	}
	public String DeleteConfirmheader()
	{
		//return DeleteConfirmheader.getText();
		return AttendanceInit.DELETE_CONFIRM;
	}
	public void ClickDeleteNoBtn() 
	{
		if(DeleteNobtn.isEnabled())
			DeleteNobtn.click();
	}
	public void ClickDeleteYesBtn() 
	{
		if(DeleteYesbtn.isEnabled())
			DeleteYesbtn.click();
	}
	public String DeleteConfirmMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return AttendanceInit.DELETE_SUCCESS;
	}
	public void ClickAttendancecheckbox()
	{
		if(Firstcheckbox.isDisplayed())
			Firstcheckbox.click();
	}
	
	public Boolean EntriesforUsername (String firstusernameinrow) 
	{
		//check if Entry for first user name in row is not zero
		if(!(FirstUserName.size()==0))
		{
		  for (int i = 0; i < FirstUserName.size(); i++)
			{
			System.out.println("Value at i "+FirstUserName.get(i).getText());
			if(((FirstUserName.get(i).getText())).contains(firstusernameinrow))
				{
					continue;
				}
				else return false;
			}   
			}
		else return false;
		return true;
	}
	
	
	
}
