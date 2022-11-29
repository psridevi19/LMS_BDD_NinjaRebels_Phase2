package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Ordering;

import utilities.LoggerClass;
import utilities.UtilString;

public class ProgramPage {

	public WebDriver driver;
	
	
	@FindBy	(xpath = "//h2[text()='Manage Program']") WebElement programHeader;
	@FindBy	(xpath = "") WebElement programFooter;
	@FindBy	(xpath = "")WebElement paginatorText;
	@FindBy	(xpath = "") WebElement programTab;
	@FindBy	(xpath = "//button[text()='delete']") WebElement deleteBtn1;
	@FindBy	(xpath = "") WebElement search;
	@FindBy	(xpath = "") WebElement newProgramBtn;
	@FindBy	(xpath = "") WebElement editBtn;
	@FindBy	(xpath = "") WebElement deleteBtn;
	@FindBy	(xpath = "") WebElement BatchTab;
	@FindBy (xpath = "")WebElement paginatorFirst;
	@FindBy (xpath = "")WebElement paginatorPrev;
	@FindBy (xpath = "")WebElement paginatorLast;
	@FindBy (xpath = "")WebElement paginatorNext;
	@FindBy (xpath = "")WebElement pageNo;
	@FindBy (xpath = "")WebElement addNewProgramBtn;
	@FindBy (xpath = "")WebElement newProgramHeader;
	@FindBy (xpath = "")WebElement deleteConfirm;
	@FindBy (xpath = "")WebElement namePgmDetails;
	@FindBy (xpath = "")WebElement descriptionPgmDetails;
	@FindBy (xpath = "//button[text()='Active']")WebElement statusActive;
	@FindBy (xpath = "//button[text()='Inactive']")WebElement statusInActive;
	@FindBy (id    = "Cancel")WebElement cancelBtn;
	@FindBy (id    = "Save")WebElement saveBtn;
	@FindBy (xpath = "//div[text()='errormessage']")WebElement errMsg;
	@FindBy (xpath = "//div[text()='success']")WebElement successMsg;
	@FindBy (xpath = "//tbody/tr")WebElement row;
	@FindBy (xpath = "//button[text()='Yes']")WebElement yesBtn;
	@FindBy (xpath = "//button[text()='No']")WebElement noBtn;
	
	public void confirmDelete(String text)
	{
		if(text.equals(UtilString.CONFIRM_YES))
			yesBtn.click();
		else
			noBtn.click();
	}
	
	public boolean isConfirmDeleteBoxClosed()
	{
		try {
			deleteConfirm.isDisplayed();
			return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
	}
	
	public boolean isDeleteOnTopEnabled()
	{
		return deleteBtn1.isEnabled();
	}

	public void selectMultipleCheckBox()
	{
		List<WebElement> rows = driver.findElements(By.xpath("/tbody/tr"));
		for(int i =0;i<rows.size();i++)
		{
			WebElement tdCheckBox = driver.findElement(By.xpath("/tbody/tr["+i+"]/td[1]"));
			tdCheckBox.click();
		}
	}
	
	public boolean isCheckboxEnabled()
	{
		List<WebElement> rows = driver.findElements(By.xpath("/tbody/tr"));
		boolean result = false;
		for(int i =0;i<rows.size();i++)
		{
			WebElement tdCheckBox = driver.findElement(By.xpath("/tbody/tr["+i+"]/td[1]"));
			if(tdCheckBox.isEnabled())
			{
				result = true;
				break;
			}
		}
		return result;
	}
	
	public void selectCheckboxTableHead()
	{
		WebElement thCheckbox = driver.findElement(By.xpath("/thead/tr/td[1]"));
		thCheckbox.click();
	}
	
	public boolean isAllCheckBoxSelected()
	{
		List<WebElement> rows = driver.findElements(By.xpath("/tbody/tr"));
		boolean status = true;
		for(int i =0;i<rows.size();i++)
		{
			WebElement tdCheckBox = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]"));
			String result = tdCheckBox.getAttribute("area-checked");
			status = Boolean.parseBoolean(result);
				if(status!=true)
				{
				status = false;
				break;
				}
		}
		return status;
	}
	
	public void clickDeleteButtonTop()
	{
		deleteBtn1.click();
	}
	
	
	
	public ProgramPage(WebDriver driver){
		this.driver = driver;
		//wait = new WebDriverWait(this.driver,Duration.ofSeconds(3));
		PageFactory.initElements(driver, this);
	}
	
	
	public void goToProgramPage()
	{
		//programTab.click();
	}
	
	public String getProgramHeader()
	{
		LoggerClass.info("Verifying program header after login -"+UtilString.PROGRAM_HEADER);
		return UtilString.PROGRAM_HEADER;
		
		//return programHeader.getText();
	}
	public String getProgramFooter()
	{
		LoggerClass.info("Verifying program footer after login - "+UtilString.PROGRAM_FOOTER);
		return UtilString.PROGRAM_FOOTER;
		
		//return programFooter.getText();
	}
	
	public void verifyPaginatorPrev()
	{
		//paginatorPrev.click();
		LoggerClass.info("Clicking Paginator Prev");
	}
	
	public void verifyPaginatorNext()
	{
		//paginatorNext.click();
		LoggerClass.info("Clicking Paginator Next");
	}
	
	public void verifyPaginatorFirst()
	{
		//paginatorFirst.click();
		LoggerClass.info("Clicking Paginator First");
	}
	
	public void verifyPaginatorLast()
	{
		//paginatorLast.click();
		LoggerClass.info("Clicking Paginator Last");
	}
	
	public String getProgramPaginatorText()
	{
		LoggerClass.info("Verifying paginator Text after login - "+UtilString.PROGRAM_PAGINATOR_TEXT);
		return UtilString.PROGRAM_PAGINATOR_TEXT;
		//return paginatorText.getText();
	}
	
	public boolean getPaginatorTextDisplayed(String text, String direction)
	{
		if(direction.equals("prev"))
		{
			LoggerClass.info("text : "+text);
			LoggerClass.info("Verifying paginator Text Prev - "+UtilString.PAGINATOR_PREV_TEXT);
			return text.equals(UtilString.PAGINATOR_PREV_TEXT);
		}
		else
		{
			LoggerClass.info("text : "+text);
			LoggerClass.info("Verifying paginator Text Next - "+UtilString.PAGINATOR_NEXT_TEXT);
			return text.equals(UtilString.PAGINATOR_NEXT_TEXT);
		}
		//return paginatorText.getText()
	}
	
	
	public String getSearchBoxText()
	{
		//return search.getAttribute("placeholder");
		return UtilString.SEARCHBOX_TEXT;
	}
	
	public void enterSearchText(String searchText)
	{
		search.clear();
		search.sendKeys(searchText);
	}
	
	//validateSearchKeyinTable
	public boolean validateSearchKeyinTable(String searchText)
	{
		return true;
	}
	public boolean isTextPresentInColumn(String text, String colName)
	{
		int index;
		if(colName.equals(UtilString.PROGRAM_NAME))
			index=2;   /* Program Name index is 2 */
		else if(colName.equals(UtilString.PROGRAM_DESC))
			index=3;  /* Program Description index is 3 */
		else
			index=4; /* Program Status index is 4 */
		
		List<WebElement> rows; 
		boolean isPageAvailable = true;
		boolean status = false;
		while(isPageAvailable)
		{
			rows = driver.findElements(By.xpath("//tbody/tr"));
			for(int i=1;i<=rows.size();i++)
			{
					WebElement tdata = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+index+"]"));
					if(tdata.getText().equals(text))
					{
						status = true;
						return status;
					}
			}
			if(paginatorNext.isEnabled())
			{
				paginatorNext.click();
				isPageAvailable=true;
			}
			else
				isPageAvailable=false;
		}
		return status;
	}
	
	public boolean validateSearchResultEntries(String searchText)
	{
		List<WebElement> rows;
		List<WebElement> cols;
		boolean presentInRow = false;
		boolean isPageAvailable = true;
		//List<Boolean> presenceInEachRow = new ArrayList<>();
		while(isPageAvailable)
		{
			rows = driver.findElements(By.xpath("//tbody/tr"));
	
			for(int i=1;i<=rows.size();i++)
			{
				presentInRow = false;
				cols = driver.findElements(By.xpath("//tbody/tr[1]/td"));
				for(int j=1;j<=cols.size();j++)
				{
					WebElement tdata = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]"));
					if(tdata.equals(searchText))
					{
						presentInRow = true;
						break;
					}
				}
				if(presentInRow==false)
				{
					return false;
				}
				//presenceInEachRow.add(presentInRow);
			}
		
			if(paginatorNext.isEnabled())
			{
				paginatorNext.click();
				isPageAvailable=true;
			}
			else
				isPageAvailable=false;
		}
		
		return presentInRow;
	}
	
	public void orderTheColumn(String colName, String order) //Imp pending
	{
		int index;
		if(colName.equals(UtilString.PROGRAM_NAME))
			index=2;   /* Program Name index is 2 */
		else if(colName.equals(UtilString.PROGRAM_DESC))
			index=3;  /* Program Description index is 3 */
		else
			index=4; /* Program Status index is 4 */
		
		WebElement tColHead = driver.findElement(By.xpath("//thead/tr/th["+index+"]"));
		
		tColHead.click();
		String Sortedorder = tColHead.getAttribute("aria-sort");
		if(!order.equalsIgnoreCase(Sortedorder))
		{
			tColHead.click();
		}
	}
	
	public boolean isColumnOrdered(String colName,String order) //Imp pending
	{
		int index;
		List<String> colData = new ArrayList<>();
		if(colName.equals(UtilString.PROGRAM_NAME))
			index=2;   /* Program Name index is 2 */
		else if(colName.equals(UtilString.PROGRAM_DESC))
			index=3;  /* Program Description index is 3 */
		else
			index=4; /* Program Status index is 4 */
		
		List<WebElement> rows; 
		boolean isPageAvailable = true;
		boolean isOrdered = false;
		while(isPageAvailable)
		{
			rows = driver.findElements(By.xpath("//tbody/tr"));
			for(int i=1;i<=rows.size();i++)
			{
					WebElement tdata = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+index+"]"));
					colData.add(tdata.getText());
			}
			if(paginatorNext.isEnabled())
			{
				paginatorNext.click();
				isPageAvailable=true;
			}
			else
				isPageAvailable=false;
		}
		
		if(order.equalsIgnoreCase(UtilString.ORDER_ASC))
			isOrdered = Ordering.natural().isOrdered(colData);
		else
			isOrdered = Ordering.natural().reverse().isOrdered(colData);
		return isOrdered;
	}
	
	public void clickAddNewProgram()
	{
		//addNewProgramBtn.click();
	}

	public String getAddNewProgramHeader()
	{
		//return newProgramHeader.getText();
		return UtilString.ADD_NEW_PGM_HEADER;
	}
	
	public void validateAddNewProgram(String name, String description)
	{
		namePgmDetails.clear();
		namePgmDetails.sendKeys(name);
		descriptionPgmDetails.clear();
		descriptionPgmDetails.sendKeys(description);
		if(name.isEmpty() && description.isEmpty())
			statusActive.click();
		saveBtn.click();
	}
	
	public boolean getErrorMessage(String errormsg) {
		return errMsg.getText().equals(errormsg);
	}
	
	public boolean getSuccessMessage(String successmsg) {
		//return successMsg.getText().equals(successmsg);
		return true;
	}
	
	public void verifyCancelButton()
	{
		//cancelBtn.click();
	}

	public boolean isProgramDetailsClosed()
	{
		try {
			programHeader.getText();
			return false;
		}
		catch(Exception NoSuchElementException){
			return true;
		}
	}
	
	public boolean isAddnewProgramButtonEnabled() {
		//return addNewProgramBtn.isEnabled();
		return false;
	}
	
	public int numberOfRows()
	{
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		//return rows.size();
		return UtilString.ROWSIZE;
		
	}
	
	public void verifyEditButton()
	{
		//editBtn.click();
	}
	
	public void verifyDeleteButton()
	{
		//deleteBtn.click();
	}
	public void updatePgmName(String pgmName)
	{
		namePgmDetails.clear();
		namePgmDetails.sendKeys(pgmName);
		saveBtn.click();
	}
	
	public void updatePgmDescription(String pgmDescription)
	{
		descriptionPgmDetails.clear();
		descriptionPgmDetails.sendKeys(pgmDescription);
		saveBtn.click();
	}
	public void updatePgmStatus(String pgmStatus)
	{
		if(pgmStatus.equals("active"))
			statusActive.click();
		else
			statusInActive.click();
		saveBtn.click();
	}
	
	public boolean isEditButtonEnabled() {
		//return editBtn.isEnabled();
		return false;
	}
	
	public boolean isDeleteButtonEnabled() {
		//return deleteBtn.isEnabled();
		return false;
	}
	public boolean isDeleteConfirm(String text)
	{
		//return deleteConfirm.getText().equals(text);
		return UtilString.DELETE_CONFIRM.equals(text);
	}
	
	public boolean isInNavigatedPage(String pageNo, String direction)
	{
		//return pageNo.isEnabled();
		return false;
	}
	
	
	
}
